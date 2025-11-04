## **Phase 5 – Infrastructure & Cross-Cutting Concerns**
*(Where we make the backend behave like an adult — logging, exceptions, and configuration finally get their turn.)*

---

### **Goal**
Add the invisible-but-essential systems: error handling, logging, configuration management, and application properties.  
Copilot can scaffold these quickly, but *you* must ensure the tone, format, and boundaries make sense.

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot thinks all errors deserve `500`. | Teach it the difference between bad data and bad code. |
| It can generate `@RestControllerAdvice` beautifully — if you ask nicely. | Always specify “return JSON error response.” |
| Copilot loves `System.out.println`. | Replace with SLF4J logging — grown-up logs only. |
| It won’t invent config keys unless you mention them. | Say “read limit from application.yml.” |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. GlobalExceptionHandler** | You | Create file `config/GlobalExceptionHandler.java` and type:<br>`// create @RestControllerAdvice class to handle InsufficientBalanceException and generic errors with JSON output` | Copilot generates handler methods. | Keep return type `ResponseEntity<Map<String,Object>>`. | Don’t accept `ResponseEntity<String>` — it looks amateur in APIs. |
| **2. Custom Exceptions** | You | In `model` or `exception` package:<br>`// create InsufficientBalanceException extending RuntimeException` | Copilot writes basic class. | Keep it simple. | Don’t let it add extra constructors you don’t need. |
| **3. LoggingConfig** | You | In `config/LoggingConfig.java`:<br>`// configure logging pattern for service and controller layers` | Copilot adds logback or SLF4J examples. | Accept structured logging (timestamp, class). | Don’t keep `System.out.println` — delete on sight. |
| **4. AppProperties** | You | `// create @ConfigurationProperties class for transaction limits and email recipients` | Copilot generates POJO with prefix. | Move default limits to `application.yml`. | Don’t let it use `@Value` for 20 fields — messy later. |
| **5. YAML Config** | You | In `application.yml`:<br>`transaction:`<br>&nbsp;&nbsp;`daily-limit: 10000` | Copilot formats YAML correctly. | Verify indentation. | Don’t paste random YAML Copilot suggests without checking syntax. |
| **6. EmailNotificationService** | You | `// create service to send summary email (mock log only)` | Copilot writes fake email method. | Log “Email sent” instead of real SMTP. | Don’t accept code using javax.mail — unnecessary for demo. |
| **7. Verify Logging** | You | Run transfer API and check console. | Logs and exceptions look clean. | Confirm timestamp and level. | Don’t ignore warnings — fix missing config keys. |
| **8. Commit** | You | `git add . && git commit -m "Phase 5 – infrastructure and cross-cutting"` | Stable infrastructure added. | Small, readable commit. | Don’t merge half-done config with main branch. |

---

### **How to Prompt Copilot for These Features**

| Task | Example Prompt | Why It Works |
|------|----------------|--------------|
| Global handler | `// create @RestControllerAdvice to handle all exceptions as JSON responses` | Copilot builds full exception handler automatically. |
| Logging | `// add SLF4J logger and log at info level for success, error level for failure` | Generates consistent log pattern. |
| Config | `// create config class with @ConfigurationProperties(prefix = "transaction")` | Copilot maps YAML keys to fields correctly. |
| Mock email | `// create service that logs “Email sent to finance team”` | Copilot generates placeholder implementation. |

---

### **Plain-English Tips (Still Funny, Still True)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot logs everything except its own mistakes.”** | Always review log placement — less is more. |
| **“If every exception becomes 500, users think you broke the bank.”** | Return accurate HTTP codes; validation errors ≠ server crash. |
| **“Your YAML is your contract — break it, and Spring breaks you.”** | Validate property names after Copilot generates config. |
| **“Fake the email, log the success, sleep well.”** | No need to set up SMTP; simulate it with logs. |

---

### **Video Placeholder**
![Watch Demo Video](../../assets/phase5-infrastructure-demo.gif)
_Show: Copilot generating GlobalExceptionHandler, reading config from YAML, and printing clean logs._

---

✅ After this phase:
- Error handling and logging are standardized.
- Configurations are externalized and readable.
- You’ve reached a stable, production-like baseline.