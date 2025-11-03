## **Phase 6 – Async & Scheduling**
*(Where Copilot learns to multitask — and you learn to set alarms that actually work.)*

---

### **Goal**
Introduce background jobs and scheduled tasks.  
You’ll create async operations (for simulated external fund transfers) and daily summary jobs that run automatically.  
Copilot handles the syntax; you handle the timing and sanity.

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot writes `@Async` like it’s candy. | Make sure you actually need it. |
| `@Scheduled` works best on `@Component` or `@Service` beans. | Tell Copilot exactly where to place it. |
| Copilot doesn’t understand “every night” or “morning” — use cron expressions. | Always specify frequency. |
| Async methods need an `@EnableAsync` class. | Without it, nothing runs — and you’ll think Copilot broke Spring. |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. Enable Async** | You | Create file `config/AsyncConfig.java` and type:<br>`// enable async execution in Spring Boot` | Copilot writes class with `@EnableAsync`. | Keep it short. | Don’t let it import executor pools yet — simple first. |
| **2. ExternalTransfer Simulation** | You | In `service/TransferService.java`, type:<br>`// simulate external transfer using @Async to mimic NEFT/RTGS delay` | Copilot adds async method that sleeps 2 seconds before marking success. | Accept mock delay logic. | Don’t accept real `Thread.sleep()` inside main thread. |
| **3. Email Summary Job** | You | In `scheduler/DailySummaryJob.java`:<br>`// create @Scheduled job that logs total approved transactions at 9 AM daily` | Copilot writes cron or fixedRate task. | Review cron syntax. | Don’t accept `@Scheduled(fixedRate = 1000)` unless you love spam. |
| **4. Inject ReportService** | You | Add comment:<br>`// use ReportService to calculate total transfers and print summary` | Copilot autowires ReportService and logs results. | Perfect reuse of earlier code. | Don’t accept job that directly queries repository — keep it clean. |
| **5. Handle Errors in Job** | You | `// wrap job logic in try/catch and log errors` | Copilot adds proper logging. | Use `error` level logs. | Don’t silently ignore exceptions. |
| **6. Verify Execution** | You | Run the app, watch logs. | See messages like:<br>`[Async] Transfer initiated...`<br>`[Scheduler] Daily summary executed` | Confirm job runs as expected. | Don’t panic if it doesn’t trigger — check `@EnableScheduling`. |
| **7. Commit** | You | `git add . && git commit -m "Phase 6 – async and scheduling"` | Background tasks ready. | Clean commit. | Don’t skip testing — async bugs are sneaky. |

---

### **How to Prompt Copilot for Async & Scheduling**

| Task | Example Prompt | Why It Works |
|------|----------------|--------------|
| Enable async | `// create config class to enable async with @EnableAsync` | Generates simple config without noise. |
| Async transfer | `// add @Async method to simulate external fund transfer delay` | Copilot writes correct signature. |
| Scheduler | `// create @Scheduled job to run every day at 9 AM` | It adds cron pattern automatically. |
| Error handling | `// log errors if scheduler fails` | Keeps logs clean and debuggable. |

---

### **Plain-English Tips (and Gentle Jokes)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Async without @EnableAsync is just wishful thinking.”** | You must explicitly enable async in config. |
| **“Copilot loves tight loops — you don’t.”** | Always use reasonable schedule intervals, not 1 second. |
| **“Never test a scheduler in production.”** | Simulate first; real schedules can spam logs or duplicate jobs. |
| **“Async is not faster — it’s just politely delayed.”** | Use async for concurrency, not magic performance gains. |

---

### **Video Placeholder**
`[VIDEO_PLACEHOLDER: phase6-async-scheduling-demo.mp4]`  
_Show: Copilot generating @Async and @Scheduled methods, running job logs in console._

---

✅ After this phase:
- Your app can run background jobs and async transfers.
- Daily reports appear automatically in logs.
- Copilot now understands timing and concurrency.