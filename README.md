# 🚀 Automation Exercise API Automation Project

## 📌 Overview

This project is an API Automation Framework developed for the APIs available on Automation Exercise.

The framework validates all 14 API test cases provided by the website using Rest Assured and TestNG while following automation testing best practices such as:

- Configuration Management
- Test Data Management
- Serialization & Deserialization
- Reusable Assertions
- Reporting with Allure

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|----------|
| Java | Programming Language |
| Maven | Dependency Management |
| Rest Assured | API Testing |
| TestNG | Test Execution |
| Jackson | Serialization / Deserialization |
| Allure Report | Reporting |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── pojo
│   │   └── utilis
│   └── resources
│       ├── TestData
│       │   ├── RegisterUser.json
│       │   └── ExpectedMessages.json
│       └── config.properties
│
└── test
    └── java
        └── TestCases
            ├── BaseTest
            ├── TestCase1
            ├── TestCase2
            └── ...
```

---

## ✅ Covered APIs

| API | Description |
|------|------------|
| API 1 | Get All Products List |
| API 2 | POST To All Products List |
| API 3 | Get All Brands List |
| API 4 | PUT To All Brands List |
| API 5 | Search Product |
| API 6 | Search Product Without Parameter |
| API 7 | Verify Login With Valid Details |
| API 8 | Verify Login Without Email |
| API 9 | DELETE To Verify Login |
| API 10 | Verify Login With Invalid Details |
| API 11 | Create User Account |
| API 12 | Delete User Account |
| API 13 | Update User Account |
| API 14 | Get User Details By Email |

---

## 🔄 Account Lifecycle Scenario

The framework validates a complete user lifecycle:

```text
Create Account
      ↓
Update Account
      ↓
Get User Details
      ↓
Delete Account
```

---

## 📄 Test Data Management

Request bodies and expected results are stored externally in JSON files.

```text
TestData
├── RegisterUser.json
└── ExpectedMessages.json
```

The framework uses Jackson for:

- Serialization
- Deserialization
- JSON → Java Object Mapping
- Java Object → Map Conversion

---

## ⚙️ Configuration Management

All URLs and endpoints are managed through:

```properties
baseUrl=https://automationexercise.com/api

productsList=/productsList
brandsList=/brandsList
searchProduct=/searchProduct
verifyLogin=/verifyLogin
createAccount=/createAccount
deleteAccount=/deleteAccount
updateAccount=/updateAccount
getUserDetail=/getUserDetailByEmail
```

---

## ▶️ Running Tests

Execute all tests:

```bash
mvn clean test
```

Execute using TestNG XML:

```bash
mvn test
```

---

## 📊 Allure Reporting

Generate report:

```bash
allure serve allure-results
```

Generate static report:

```bash
allure generate allure-results --clean -o allure-report
```

Open report:

```bash
allure open allure-report
```

---

## 📸 Allure Report

Add screenshots here after generating reports.

### Dashboard

![Allure Dashboard](screenshots/dashboard.png)

### Suites

![Allure Suites](screenshots/suites.png)

---

## 🎯 Key Framework Features

- REST Assured API Testing
- TestNG Test Management
- Jackson Serialization & Deserialization
- Reusable Assertions Helper
- Config Driven Framework
- JSON Based Test Data
- Allure Reporting
- Dynamic Test Data Generation
- CRUD Workflow Validation

---

## 👨‍💻 Author

**Mark Hany**

EDGES Software Testing Diploma · API Testing Final Project

GitHub: https://github.com/Mark4111
LinkedIn: https://www.linkedin.com/in/mark-hany-040110241/
