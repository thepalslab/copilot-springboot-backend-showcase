## **Phase 7 – Testing & Quality Assurance**
*(Where Copilot learns humility — and you finally make it prove what it wrote actually works.)*

---

### **Goal**
Add proper testing for your services, controllers, and validation rules.  
Copilot can generate test skeletons at lightspeed, but only humans can decide what’s a good assertion.  
This phase turns code from “looks fine” to “definitely works.”

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot will happily mock anything — even what doesn’t exist. | Review imports and types carefully. |
| Test method names guide Copilot’s logic. | Name them descriptively, like `shouldTransferFundsWhenBalanceIsSufficient()`. |
| It loves JUnit 4 nostalgia. | Always specify JUnit 5 and Mockito for modern projects. |
| Copilot doesn’t know your business rules. | You must write a clear comment describing the expected behavior. |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. Create test packages** | You | Ensure `src/test/java/com/example/bankingcore/` exists. | Ready for test classes. | — | Don’t mix tests under `main/java`. |
| **2. TransferServiceTests** | You | In new test class, type:<br>`// write JUnit 5 test for transferFunds when balance is sufficient` | Copilot generates test with mocks and assertions. | Accept structure, refine inputs. | Don’t trust hardcoded IDs or wrong account names. |
| **3. FraudCheckServiceTests** | You | `// write unit test for FraudCheckService blocking over-limit transfers` | Copilot builds test with dummy data. | Confirm exception type matches your rule. | Don’t accept magic numbers — replace with constants. |
| **4. AccountServiceTests** | You | `// test getAccountById returns correct account` | Copilot writes repository mock test. | Keep test small and focused. | Don’t accept 3 methods testing the same thing. |
| **5. ControllerTests** | You | `// write MockMvc test for /api/transfers POST endpoint` | Copilot builds SpringBootTest setup. | Works for integration tests. | Don’t accept it if it forgets `@WebMvcTest`. |
| **6. Validation Tests** | You | `// write test for TransferRequest validation with negative amount` | Copilot writes `@Valid` test case. | Assert proper exception. | Don’t let it expect 500; validation errors are 400. |
| **7. Integration Tests** | You | `// write integration test to verify fund transfer updates both account balances` | Copilot sets up H2 test run. | Good to verify DB changes. | Don’t skip rollback — add `@Transactional` if needed. |
| **8. Commit** | You | `git add . && git commit -m "Phase 7 – testing and QA"` | Tests committed. | Keep test names clear. | Don’t commit failing tests unless intentional. |

---

### **How to Prompt Copilot for Tests**

| Task | Example Prompt | Why It Works |
|------|----------------|--------------|
| Unit test generation | `// write JUnit 5 test for TransferService.transferFunds()` | Copilot detects mocks automatically. |
| Negative test case | `// test transferFunds throws InsufficientBalanceException when balance too low` | Generates scenario with exception check. |
| Integration test | `// write @SpringBootTest verifying database updates after transfer` | Creates in-memory DB test. |
| Validation test | `// test that invalid TransferRequest fails validation` | Helps cover bean validation annotations. |

---

### **Plain-English Tips (With a Dash of Brutal Honesty)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot passes every test — especially the ones it didn’t run.”** | Always execute and verify tests manually. |
| **“A failing test teaches more than 10 passing ones.”** | Don’t delete red tests; learn why they failed. |
| **“Mocks are like lies — small ones are fine, too many break trust.”** | Keep your test focused on one behavior. |
| **“Coverage isn’t a badge, it’s a safety net.”** | Aim for meaningful coverage, not 100% decoration. |

---

### **Video Placeholder**
![Watch Demo Video](../../assets/phase7-testing-demo.gif)
_Show: Copilot generating a test class, editing assertions, and running tests with green results._

---

✅ After this phase:
- Unit, validation, and integration tests exist.
- Copilot can auto-complete future tests based on patterns you set.
- The project finally has guardrails.