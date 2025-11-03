## **Phase 1 – Repository Setup**

*(Where you and Copilot learn who’s the senior engineer.)*

---

### **Goal**

Get a clean, bootable Spring Boot project ready for Copilot magic.
No business logic, no README drama—just the skeleton that breathes.

---

### **Quick FYIs**

| Fact                                      | Translation                                       |
| ----------------------------------------- | ------------------------------------------------- |
| Copilot doesn’t run terminal commands.    | You still need fingers.                           |
| Copilot doesn’t create empty directories. | Make one class, then it follows orders.           |
| Copilot loves context.                    | Blank projects make it hallucinate microservices. |
| Copilot takes comments literally.         | Say “minimal” or it will build Skynet.            |

---

### **Setup Table**

### **Setup Table**

| Step | Who | Prompt / Action | Result | Copilot ✅ | Copilot 🚫 |
|------|-----|-----------------|---------|------------|------------|
| **1. Create Repo** | You | ```bash
gh repo create copilot-springboot-backend-showcase --public --clone
spring init --dependencies=web,data-jpa,validation,h2,actuator banking-core
``` | Local project ready | — | Don’t ask Copilot to “create GitHub repo.” It can’t run terminal commands. |
| **2. Open in IntelliJ** | You | Verify these exist:<br>`pom.xml`<br>`src/main/java/com/example/bankingcore/BankingCoreApplication.java`<br>`src/test/java/` | Project compiles | — | Don’t start typing “generate everything” before structure exists. |
| **3. Create Folders** | You | Add:<br>`controller/`<br>`service/`<br>`repository/`<br>`model/` | Directory map done | — | Copilot won’t create folders automatically. |
| **4. First Class Trigger** | You | Inside `model/` add comment:<br>`// create empty placeholder class so Copilot starts noticing folders` | Copilot now “sees” structure | Do this – first class helps Copilot detect structure. | Don’t leave folders empty. |
| **5. Main Application** | Copilot | In `BankingCoreApplication.java` type:<br>`// create main Spring Boot app class with @SpringBootApplication` | Copilot writes main class | Accept its code, rename package if off. | Don’t ask for “complex starter” – it’ll add GraphQL and MQTT. |
| **6. Dependencies** | Copilot | In `pom.xml` type:<br>`<!-- add dependencies for spring-boot-starter-web, data-jpa, validation, h2 -->` | Proper dependency list | Let Copilot fill XML. | Don’t say “add everything I may need” – you’ll get Kafka & aliens. |
| **7. Run and Check** | You | Run from IntelliJ toolbar | Should print:<br>**Started BankingCoreApplication…** | Verify startup success. | Skip debugging until the next phase. |
| **8. Commit Once** | You | ```bash
git add .
git commit -m "Phase 1 – skeleton project"
``` | Safe checkpoint | Good habit. | Don’t bundle Copilot’s experiments into one large commit. |


---

### **One-Liners to Remember**

* *Copilot is fast, not wise.*
* *You describe; it types.*
* *Empty folders are invisible to its little robot eyes.*
* *If your prompt sounds like a wish, expect a genie disaster.*

---

### **Video Placeholder**

`[VIDEO_PLACEHOLDER: phase1-setup-demo.mp4]`
*Show: typing the comment → Copilot generating main class → project running.*
