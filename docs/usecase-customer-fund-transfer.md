# 🏦 Use Case: Customer Fund Transfer System (Retail Banking Mini-Core)

This is the **sample backend problem** used throughout the `copilot-springboot-backend-showcase` repository.  
It gives you a realistic business context so you can see how **GitHub Copilot** helps convert requirements into working backend code.

## 🎯 Goal

To design a secure backend that manages **customer accounts**, **fund transfers**, and **transaction logs** — while ensuring proper validation, fraud detection, and audit trails.

This use case is intentionally simple enough for learning, but complex enough to explore how Copilot handles:
- Multi-layered architecture (controller → service → repository)
- Database interactions
- Transactional consistency
- Asynchronous processing
- Configuration management
- Scheduled jobs
- Testing and exception handling

## 🧩 Core Features

| Feature | Description | Copilot Learning Focus |
|----------|--------------|------------------------|
| **1. Customer Account Management** | Create and fetch customer accounts with balances. | Generate REST endpoints, entity relationships, and validation. |
| **2. Fund Transfer (Internal)** | Transfer funds between two customer accounts within the same bank. | Generate transactional service logic with rollback handling. |
| **3. Fund Transfer (External)** | Simulate NEFT/RTGS-style transfers using async queue. | Demonstrate async processing and job scheduling. |
| **4. Transaction History** | Retrieve statements filtered by date range or transaction type. | Generate JPA queries, pagination, and DTO mappings. |
| **5. Fraud Check Rules** | Reject transfers if amount exceeds daily configurable limit. | Show how to create a business-rule layer and custom exceptions. |
| **6. Audit Logging** | Record every debit/credit operation into `transaction_log`. | Use Copilot to create entity mappings and repositories automatically. |
| **7. Reporting & Alerts** | Generate daily transaction summary and email to compliance team. | Practice `@Scheduled` jobs, logging, and mock email services. |
| **8. Configuration Management (Azure)** | Keep fraud limits and email recipients in Azure App Configuration. | Demonstrate config property mapping and YAML prompt generation. |
| **9. Testing & Exception Handling** | Validate all modules with unit and integration tests. | Use Copilot to generate JUnit and Mockito scaffolds. |

## 🧱 Suggested Entities

| Entity | Key Fields | Notes |
|---------|-------------|-------|
| **Customer** | `id`, `name`, `email`, `balance` | Represents retail customer. |
| **Transaction** | `id`, `sourceAccountId`, `targetAccountId`, `amount`, `type`, `timestamp`, `status` | Logs every debit and credit. |
| **FraudRule** | `id`, `ruleName`, `dailyLimit`, `active` | Holds configuration for fraud checks. |
| **AuditLog** | `id`, `action`, `entity`, `details`, `timestamp` | Captures all system actions for audit purposes. |

## ⚙️ Sample Flow

1. **Customer initiates fund transfer**  
   → `FundTransferController` receives API request.  
2. **Validation & fraud check**  
   → `FundTransferService` checks daily limits.  
3. **Balance update with transaction**  
   → Deduct from source, add to target, and log to `transaction_log`.  
4. **Audit entry created**  
   → Record details in `AuditLog` table.  
5. **Daily reporting job**  
   → Scheduled service compiles transactions and emails summary.  

Each of these steps becomes an **opportunity to experiment with Copilot** — prompt by intent, then observe and refine.

## 🏗️ Architectural Overview

```text
src/main/java/com/example/bank/
├── controller/
│   ├── CustomerController.java
│   └── FundTransferController.java
├── service/
│   ├── CustomerService.java
│   ├── FundTransferService.java
│   └── ReportingService.java
├── repository/
│   ├── CustomerRepository.java
│   ├── TransactionRepository.java
│   └── AuditLogRepository.java
├── model/
│   ├── Customer.java
│   ├── Transaction.java
│   ├── FraudRule.java
│   └── AuditLog.java
└── config/
└── ApplicationConfig.java
```

You won’t manually write this structure — you’ll **guide Copilot** to generate it, file by file.
