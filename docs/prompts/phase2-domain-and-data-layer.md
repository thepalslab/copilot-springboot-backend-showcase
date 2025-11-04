## **Phase 2 – Domain & Data Layer**
*(Where Copilot finally earns its first paycheck.)*

---

### **Goal**
Define the real business objects and repositories for the **Customer Fund Transfer System**.  
In this phase you teach Copilot the “nouns” of your project — Customers, Accounts, Transactions — so that later it can write meaningful “verbs” like transferFunds() and calculateBalance().

---

### **Quick FYIs**
| Fact | Translation |
|------|--------------|
| Copilot learns from patterns in your code. | Start clean so it copies the right things. |
| Copilot guesses relationships from field names. | If you type `customer`, it assumes `@ManyToOne`. Verify it. |
| Copilot thinks all numbers are `double`. | You must insist on `BigDecimal` for money. |
| A single missing annotation breaks JPA startup. | Always confirm `@Entity` and `@Id` are present. |

---

### **Setup Table**

| Step | Who Does It | Prompt / Action | Result | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|-----------------|---------|----------------|------------------|
| **1. Create packages** | You | Make sure `model/` and `repository/` exist.<br>Copilot won’t create folders on its own. | Folder ready | — | Don’t let Copilot guess file paths; create them first. |
| **2. Customer Entity** | You start typing:<br>`// create JPA entity Customer with id, name, email, mobile`| Copilot writes full entity with annotations. | Works as expected | Accept it, check `@Entity`, `@Id`. | Don’t accept if it adds weird fields like “address” you didn’t ask for. |
| **3. Account Entity** | You | `// JPA entity Account with accountNumber, balance (BigDecimal), and link to Customer` | Copilot adds `@ManyToOne` relation. | Keep `BigDecimal` for money. | Don’t let it use `double` – precision loss is real. |
| **4. Transaction Entity** | You | `// entity Transaction with sourceAccount, targetAccount, amount, type, status, timestamp` | Copilot builds relationships and enums. | Check foreign keys and `@Enumerated(EnumType.STRING)`. | Don’t accept `EnumType.ORDINAL` – DB mismatch risk. |
| **5. Enum Creation** | Copilot | Type:<br>`// enum TransactionType with DEBIT, CREDIT, TRANSFER` | Enum ready for use. | Keep names simple. | Don’t rename enums later – DB queries will cry. |
| **6. Repositories** | You | `// create JpaRepository for Account` and similar for Customer and Transaction | Copilot writes interfaces. | Accept clean ones only. | Don’t accept auto queries you don’t need yet. |
| **7. Schema Check** | You | Run the app with H2 console enabled.<br>Open `jdbc:h2:mem:testdb`. | Tables appear automatically. | Confirm relationships exist. | Don’t panic about `ddl-auto=create` in dev. |
| **8. Commit** | You | `git add . && git commit -m "Phase 2 – domain and repositories"` | Safe checkpoint. | Keep commits focused. | Don’t mix service logic here – that’s Phase 3. |

---

### **Plain-English Tips (with Humor Intact)**

| Fun Line | What It Means |
|-----------|---------------|
| **“Copilot learns your nouns before it speaks verbs.”** | Create entities first. Once Copilot knows what a Customer and Account are, it can write business logic later. |
| **“Money deserves BigDecimal, not floating-point drama.”** | Always use `BigDecimal` for currency. Copilot loves `double`, but you won’t love the rounding errors. |
| **“Entity relationships deserve a sanity check — always review what Copilot auto-wires.”** | Check every `@ManyToOne` or `@OneToMany` it adds. Wrong direction = endless NullPointerException debugging. |
| **“Enums: the smallest file that breaks the biggest query.”** | Once enum names go to DB, changing them later breaks old data. Treat them as schema, not casual code. |

---

### **Video Placeholder**
![Watch Demo Video](../../assets/phase2-domain-demo.gif)
_Show: typing prompt → Copilot generating entities → verifying schema in H2 console._

---

✅ After this phase:  
- Entities compile and map correctly.  
- Copilot understands your domain language.
```
