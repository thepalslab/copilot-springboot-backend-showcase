## **Phase 3 – Service Layer**
*(Where Copilot starts handling money — and you start watching closely.)*

---

### **Goal**
Build the **business logic** layer of the Customer Fund Transfer System.  
This is where Copilot stops writing simple CRUD and starts guessing logic — sometimes correctly, sometimes like a toddler with a credit card.

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot knows how to call repositories but not your business rules. | You must describe what the method should *do*, not just *exist*. |
| Transactions in banking are sacred. | Always use `@Transactional` to prevent double debits. |
| Copilot mixes math and logic easily. | Verify balance updates manually — no invisible overdrafts. |
| Logging saves lives. | Add log statements even if Copilot forgets. |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. Create package** | You | `service/` folder already exists from Phase 1. | Ready to use. | — | Don’t dump all services into one file. |
| **2. AccountService** | You start typing:<br>`// create AccountService with methods to openAccount(), getAccountById(), updateBalance()` | Copilot scaffolds a `@Service` class. | Good foundation. | Let it use constructor injection. | Don’t accept `@Autowired` field injection. |
| **3. TransferService** | You | `// create TransferService to transfer funds between two accounts with balance check and @Transactional` | Copilot generates logic calling AccountRepository. | Check for both debit and credit. | Don’t accept if it misses rollback or null checks. |
| **4. FraudCheckService** | You | `// create FraudCheckService to validate daily transfer limit per account` | Copilot writes validation code. | Replace random limits with constants or config. | Don’t accept if it hardcodes “10000” – teach it to read from config later. |
| **5. Transaction Logging** | You | `// after each successful transfer, create Transaction record and save it` | Copilot adds log entry and repository call. | Ensure consistent `TransactionType`. | Don’t let it create log before commit. |
| **6. ReportService** | You | `// create ReportService to summarize total transfers per account or per day` | Copilot builds aggregation query. | Check query correctness. | Don’t let it use native SQL unless needed. |
| **7. Logging** | You | Type inside TransferService:<br>`// add log info for transaction start and completion` | Copilot writes SLF4J logs. | Keep `info` for normal ops, `error` for exceptions. | Don’t let it log passwords or account numbers. |
| **8. Commit** | You | `git add . && git commit -m "Phase 3 – service layer logic"` | Service layer ready. | One small commit. | Don’t push untested code — next phase adds controllers. |

---

### **How to Prompt Copilot in Services**

| Goal | Example Prompt | Why It Works |
|------|----------------|--------------|
| Balance check | `// if source account balance < amount, throw InsufficientBalanceException` | Copilot writes a readable `if` and exception. |
| Atomic transaction | `// perform debit and credit in single @Transactional method` | It wraps logic correctly in one DB call. |
| Logging | `// log transaction start and end with IDs` | Adds structured logs automatically. |
| Validation | `// ensure both accounts exist before transfer` | Copilot adds defensive null checks. |

---

### **Plain-English Tips (with Humor Intact)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot writes fast, not safe.”** | Always review logic — it’s your money on the line. |
| **“If you don’t say @Transactional, Copilot forgets it.”** | Explicitly ask for transactions; it rarely adds them itself. |
| **“Logging is the only honest witness in production.”** | Make sure every transfer logs success and failure clearly. |
| **“Don’t ask Copilot for ‘smart fraud detection.’”** | It’ll try to build AI with no data — stick to simple rule checks. |

---

### **Video Placeholder**
`[VIDEO_PLACEHOLDER: phase3-service-layer-demo.mp4]`  
_Show: Copilot generating transfer logic, adding @Transactional, creating transaction logs._

---

✅ After this phase:
- You have working service classes with real logic.
- Transfers work safely inside transactions.
- Logs and exceptions are in place.
