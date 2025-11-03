## **Phase 9 – Prompt Engineering & Reflection**
*(Where you stop fighting Copilot and start collaborating with it.)*

---

### **Goal**
Understand how prompt structure changes Copilot’s behavior, document your lessons learned, and build a mini “prompt library” for future developers.  
By now, you’ve coded, debugged, and refactored — it’s time to capture what works.

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot is context-hungry. | Keep open files relevant to the prompt. |
| Comments are your UX interface. | Clear comment = smart suggestion. |
| It learns your coding tone. | Consistent style yields consistent completions. |
| Too-long prompts confuse it. | Short, specific, action-oriented prompts work best. |

---

### **Prompt Engineering Table**

| Situation | Weak Prompt | Better Prompt | Why Better |
|------------|--------------|----------------|-------------|
| Creating methods | `// write function for transfers` | `// create method transferFunds() that checks balance, updates both accounts, and logs success` | Gives Copilot purpose + boundaries. |
| Tests | `// test transfer` | `// write JUnit 5 test for transferFunds throwing InsufficientBalanceException` | Adds intent and expected behavior. |
| Refactor | `// make this clean` | `// extract reusable method validateTransferRequest()` | Action + target defined clearly. |
| Docs | `// explain` | `// summarize this class in one line for internal documentation` | Specific length and audience. |
| Config | `// add properties` | `// add YAML config keys for transaction limits and email recipients` | Context reduces random guesses. |

---

### **Reflection & Practice Integration**

| Step | Task | Example Output |
|------|------|----------------|
| **1. Collect Prompts** | Review your commits and note all successful prompts. | “Add JPA entity…” “Write controller…” “Explain stack trace…” |
| **2. Categorize Them** | Group by type (entity, service, debug, refactor). | Makes a team-wide library. |
| **3. Capture Failures** | Record prompts that gave junk results. | Avoid them next time. |
| **4. Add to prompt.md** | Append best examples to main `prompts/prompt.md`. | Knowledge base for new devs. |
| **5. Share in README or wiki.** | Document what worked, what didn’t. | Spreads good Copilot habits. |

---

### **Plain-English Tips (and a Wink)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot mirrors your clarity.”** | If your prompt is vague, your code will be too. |
| **“Short, sharp, specific beats poetic.”** | Avoid fluff — give Copilot instructions, not riddles. |
| **“Prompts age like fine wine — keep the good ones.”** | Build your own prompt library over time. |
| **“Copilot doesn’t learn — your team does.”** | The real improvement happens when humans document what worked. |

---

### **Video Placeholder**
`[VIDEO_PLACEHOLDER: phase9-prompt-reflection-demo.mp4]`  
_Show: examples of vague vs good prompts, reviewing prompt.md, and adding lessons learned._

---

✅ After this phase:
- You’ve mastered prompting strategy and reflection.
- You can explain how and *why* Copilot behaves the way it does.
- The repository becomes a reusable Copilot learning guide for your whole team.
