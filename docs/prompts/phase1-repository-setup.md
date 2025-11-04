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

| Step | Who Does It | Prompt / Action                                                                                         | Result                                 | Copilot Do ✅ | Copilot Don’t 🚫 |
|------|--------------|---------------------------------------------------------------------------------------------------------|----------------------------------------|----------------|------------------|
| **Create Repo** | You |`gh repo <project_name> --public --clone`<br>`spring init --dependencies=web,data-jpa,validation,h2,actuator banking-core` | Local<br>project<br>ready                 | — | Don’t ask Copilot to “create GitHub repo” – it’s allergic to CLI. |
| **Open in IntelliJ** | You | Check that these exist:<br>`pom.xml`<br>`src/main/java/com/example/bankingcore/BankingCoreApplication.java`<br>`src/test/java/` | Project<br> compiles                       | — | Don’t start typing “generate everything” before structure exists. |
| **Create Folders** | You | `controller/`, <br>`service/`,<br> `repository/`,<br> `model/`                                          | Directory<br> map done                     | — | Don’t wait for Copilot – it won’t build folders out of thin air. |
| **First Class Trigger** | You | Inside `model/` type comment:<br>`// create empty placeholder class so Copilot starts noticing folders` | Copilot now<br> “sees” structure           | Do this – first class wakes it up. | Don’t leave dirs empty – Copilot gets amnesia. |
| **Main Application** | Copilot | In `BankingCoreApplication.java` type:<br>`// create main Spring Boot app class with @SpringBootApplication` | Copilot<br> writes main<br> class              | Accept its code, rename package if off. | Don’t ask for “complex starter” – it’ll add GraphQL and MQTT. |
| **Dependencies** | Copilot | In `pom.xml` type:<br>`<!-- add dependencies for spring-boot-starter-web, data-jpa, validation, h2 -->` | Proper<br> dependency<br> list                 | Let Copilot fill XML. | Don’t say “add everything I may need” – you’ll get Kafka & aliens. |
| **Run and Check** | You | Run from IntelliJ toolbar                                                                               |Should print:<br>`Started BankingCoreApplication…` | Celebrate quietly. | Don’t debug yet — Phase 2 will break it anyway. |
| **Commit Once** | You | `git add . && git commit -m "Phase 1 – skeleton project"`                                               | Safe checkpoint                        | Good habit. | Don’t bundle Copilot’s experiments into one giant commit. |

---

### **One-Liners to Remember**

* *Copilot is fast, not wise.*
* *You describe; it types.*
* *Empty folders are invisible to its little robot eyes.*
* *If your prompt sounds like a wish, expect a genie disaster.*

---

### **Video Placeholder**

[🎬 Watch Demo Video (GitHub View)](https://github.com/thepalslab/copilot-springboot-backend-showcase/raw/main/assets/phase1-setup-demo.gif)

*Show: typing the comment → Copilot generating main class → project running.*
