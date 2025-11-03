# 🧭 Copilot Spring Boot Backend Showcase — Index & Prompt Guide

Welcome to the **Copilot + Spring Boot Learning Journey** — an end-to-end project designed to teach real backend devs how to *think, debug, and build with Copilot intelligently.*

Each phase includes what to record, what to type, and where Copilot earns (or loses) its salary.

---

## 🧩 Quick Navigation

| Phase | Topic | Video | Description |
|-------|--------|--------|-------------|
| [1️⃣ Phase 1](./docs/prompts/phase1-repository-setup.md) | **Repository Setup** | `phase1-repository-setup.mp4` | Create project skeleton and basic folders (where Copilot learns manners). |
| [2️⃣ Phase 2](./docs/prompts/phase2-domain-and-data-layer.md) | **Domain & Data Layer** | `phase2-domain-and-data-layer.mp4` | Build entities and repositories — teach Copilot its nouns. |
| [3️⃣ Phase 3](./docs/prompts/phase3-service-layer.md) | **Service Layer** | `phase3-service-layer-demo.mp4` | Write the logic — where Copilot starts handling money and you start watching it closely. |
| [4️⃣ Phase 4](./docs/prompts/phase4-api-layer.md) | **API Layer** | `phase4-api-layer-demo.mp4` | Build REST endpoints — Copilot finally meets humans. |
| [5️⃣ Phase 5](./docs/prompts/phase5-infrastructure-and-crosscutting.md) | **Infrastructure & Cross-Cutting** | `phase5-infrastructure-demo.mp4` | Logging, exception handling, config — Copilot learns responsibility. |
| [6️⃣ Phase 6](./docs/prompts/phase6-async-and-scheduling.md) | **Async & Scheduling** | `phase6-async-scheduling-demo.mp4` | Make Copilot multitask (and hopefully not melt down). |
| [7️⃣ Phase 7](./docs/prompts/phase7-testing-and-quality-assurance.md) | **Testing & QA** | `phase7-testing-demo.mp4` | Teach Copilot humility through tests. |
| [8️⃣ Phase 8](./docs/prompts/phase8-code-comprehension-and-improvement.md) | **Reading, Debugging & Refactoring** | `phase8-comprehension-refactor-demo.mp4` | Make Copilot explain, clean, and fix existing code. |
| [9️⃣ Phase 9](./docs/prompts/phase9-prompt-engineering-and-reflection.md) | **Prompt Crafting & Reflection** | `phase9-prompt-reflection-demo.mp4` | Learn to speak Copilot fluently. |
| [🎬 Debugging Demo](./docs/demo-copilot-context-debugging.md) | **Context-Aware Debugging** | `copilot-context-debugging-end-to-end.mp4` | Cross-file investigation demo (Controller → Service → Repo). |

---

## 🧠 The Copilot Prompt Index

### 🪄 **Setup & Project Scaffolding**
| Goal | Prompt Example |
|------|----------------|
| Create project skeleton | `// create Spring Boot project for customer fund transfer with controller, service, and repository` |
| Add packages | `Add folder controller, service, repository, model` |
| Generate main class | `// create Application class with @SpringBootApplication` |
| Generate README summary | `// write project overview for beginners learning Copilot + Spring Boot` |

---

### 🧩 **Domain & Data Layer**
| Goal | Prompt Example |
|------|----------------|
| Create entity | `// create Account entity with id, name, and balance as BigDecimal` |
| Add relationship | `// add one-to-many relationship between Customer and Account` |
| Add repository | `// create JpaRepository for Account` |
| Add seed data | `// create CommandLineRunner to insert sample accounts` |

---

### ⚙️ **Service Layer**
| Goal | Prompt Example |
|------|----------------|
| Create service | `// create TransferService with method transferFunds()` |
| Add transaction safety | `// add @Transactional for atomic transfer` |
| Validate balance | `// throw InsufficientBalanceException if source balance < amount` |
| Log transaction | `// log transfer details using SLF4J` |

---

### 🌐 **API Layer**
| Goal | Prompt Example |
|------|----------------|
| Create controller | `// create REST controller for /api/transfers endpoint` |
| Add DTO | `// create TransferRequest with sourceId, targetId, and amount` |
| Add validation | `// validate @RequestBody with @Valid` |
| Add exception handler | `// handle InsufficientBalanceException with HTTP 400 response` |

---

### 🛠 **Infrastructure & Cross-Cutting**
| Goal | Prompt Example |
|------|----------------|
| Logging | `// configure SLF4J logger for all services` |
| Exception handling | `// create @RestControllerAdvice for global error handling` |
| Configuration | `// create @ConfigurationProperties(prefix = "transaction")` |
| YAML | `// add transaction.daily-limit property to application.yml` |

---

### 🕐 **Async & Scheduling**
| Goal | Prompt Example |
|------|----------------|
| Enable async | `// create config class with @EnableAsync` |
| Add async call | `// make externalTransfer() async with 2-second delay` |
| Add scheduler | `// create @Scheduled job to run at 9 AM daily for transaction summary` |
| Handle errors | `// catch and log exceptions in scheduled job` |

---

### ✅ **Testing & QA**
| Goal | Prompt Example |
|------|----------------|
| Unit test | `// write JUnit 5 test for transferFunds success` |
| Negative test | `// test InsufficientBalanceException thrown when balance too low` |
| MockMvc test | `// write controller test for /api/transfers POST` |
| Integration test | `// verify both account balances update after successful transfer` |

---

### 🔍 **Reading, Debugging, & Refactoring**
| Goal | Prompt Example |
|------|----------------|
| Explain code | `// explain what this method does step by step` |
| Trace data | `// where does this variable value come from?` |
| Suggest fix | `// suggest fix for missing rollback in transaction` |
| Refactor | `// refactor this class into smaller methods with better naming` |

---

### 🧠 **Prompt Engineering & Reflection**
| Goal | Prompt Example |
|------|----------------|
| Good prompt vs bad | `// create method` ❌ → `// create method transferFunds() that validates balance and logs transfer` ✅ |
| Prompt library | `// summarize all prompts used in this project for documentation` |
| Record failures | `// note which prompts gave wrong completions` |
| Share best practices | `// generate markdown summary of good Copilot prompts for backend devs` |

---

### 🐞 **Context-Aware Debugging Demo**
| Step | Prompt Example |
|------|----------------|
| Ask root cause | `Why might transferFunds() throw NoSuchElementException when called from TransferController?` |
| Ask for fix | `Suggest safer version that handles missing accounts and insufficient balance.` |
| Explain async bug | `Explain why Transaction already active might happen during async processing.` |
| Summarize flow | `Summarize end-to-end flow from API request to database save.` |

---

## 🎓 Tips for Recording

| Situation | Tip |
|------------|-----|
| Teaching setup | Zoom in on Copilot Chat window + context panel. |
| Debug demos | Show the stack trace, then the context, then Co
