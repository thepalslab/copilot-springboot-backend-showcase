## **Phase 4 – API Layer**
*(Where humans finally meet your backend — and Copilot tries to play UX designer.)*

---

### **Goal**
Expose REST endpoints for accounts, transfers, and reports using Spring Boot controllers.  
This is where Copilot starts showing off — but you’ll keep it polite, validated, and predictable.

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot loves to create controllers named “MainController.” | Always rename to something meaningful. |
| It assumes everything returns `String`. | Tell it to return real objects or DTOs. |
| It skips validation unless you mention it. | Use `@Valid` or you’ll be debugging bad JSON forever. |
| REST is not a magic word. | Be explicit about methods (`@GetMapping`, `@PostMapping`). |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. Prepare folders** | You | Ensure `controller/` folder exists. | Copilot ready to work. | — | Don’t put controllers under “service.” Keep them separate. |
| **2. AccountController** | You | Type:<br>`// create REST controller for Account with endpoints to open account and fetch account by ID` | Copilot generates controller with mappings. | Verify it injects AccountService. | Don’t accept `@RequestMapping("/")` — that’s a traffic accident waiting to happen. |
| **3. TransferController** | You | Type:<br>`// REST controller for fund transfer between two accounts with validation` | Copilot writes `@PostMapping("/api/transfers")`. | Keep endpoint paths clear and versioned. | Don’t accept endpoints with verbs (`/makeTransferNow`). |
| **4. ReportController** | You | `// REST controller for reports: get daily summary, get transactions by account` | Copilot autocompletes with `@GetMapping` methods. | Great for quick JSON output. | Don’t let it expose DB entities directly — wrap with DTOs. |
| **5. Request / Response Models** | You | When Copilot references DTOs, create them:<br>`// create TransferRequest DTO with sourceId, targetId, amount` | Copilot generates proper POJO. | Annotate with `@NotNull` and `@Positive`. | Don’t accept snake_case fields — stay consistent. |
| **6. Exception Handling** | You | `// handle InsufficientBalanceException with HTTP 400` | Copilot updates GlobalExceptionHandler. | Returns JSON error. | Don’t let it return 500 for user mistakes. |
| **7. Test with Postman or Curl** | You | Send POST `/api/transfers` with JSON body. | Funds move if all works. | Validate 200 responses. | Don’t trust Copilot-generated endpoint names blindly. |
| **8. Commit** | You | `git add . && git commit -m "Phase 4 – API layer"` | REST API ready. | Short commit message. | Don’t mix UI stubs or README edits here. |

---

### **How to Prompt Copilot in Controllers**

| Goal | Example Prompt | Why It Works |
|------|----------------|--------------|
| Create endpoint | `// REST endpoint to create new customer with validation` | Copilot adds `@PostMapping` and `@RequestBody` automatically. |
| Add validation | `// validate input with @Valid and @NotNull` | Forces proper annotations. |
| Handle response | `// return ResponseEntity with HTTP status CREATED` | Ensures API looks professional. |
| Error handling | `// catch InsufficientBalanceException and return HTTP 400` | Produces a clean JSON error format. |

---

### **Plain-English Tips (with Humor Intact)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot loves to overshare — teach it privacy.”** | Never expose raw entities; use DTOs for external data. |
| **“A controller without validation is a public demo of chaos.”** | Always add `@Valid` and field-level constraints. |
| **“If Copilot names it ‘MainController,’ rename it immediately.”** | Meaningful class names matter for readability. |
| **“Good APIs are boring — keep them boring.”** | Simple, predictable endpoints make everyone happy. |

---

### **Video Placeholder**
![Watch Demo Video](../../assets/phase4-api-layer-demo.gif)
_Show: typing controller prompt → Copilot generating endpoints → testing transfer API in Postman._

---

✅ After this phase:  
- All main REST endpoints are active.  
- Controllers handle validation and exceptions properly.  
- Copilot knows how your business logic connects to the outside world.
```
