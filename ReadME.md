# 🚀 Automation Testing Framework – Piping Rock

## 📌 Project Overview
This project automates test scenarios for *demoqa.com* using *Selenium + Java + TestNG*.  
The framework is built using the *Page Object Model (POM)* design pattern and includes reusable *helper methods* for code reusability and maintainability.

---

## ⚙ Framework Setup Instructions

### 🔹 Prerequisites
- Java JDK 8 or higher installed and configured
- Maven 3.6+ installed and configured
- IntelliJ IDEA  as IDE
- Chrome browser installed

### 🔹 Setup Steps
1. Clone the repository:  
   bash
   git clone https://github.com/sha37-x/automation-testing-demoqa
   cd automation-testing-demoqa

2. Open the project in *IntelliJ IDEA*
3. Let Maven download all dependencies automatically (from pom.xml)
4. Verify that testng.xml is present at the root level

---

## ▶ How to Execute Tests

### ✅ Run from IntelliJ (Recommended)
- Right-click on testng.xml → *Run*
- OR right-click on the project → *Run All Tests*

👉 This is the execution method I used for validating the framework.

### 🔹 (Optional) Run from Command Line
If Maven is configured, tests can also be triggered via terminal:  
bash
mvn clean test -DsuiteXmlFile=testng.xml


---
# Project Structure

piperock_automation
├── .idea/
├── screenshots/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   ├── pages/
│       │   └── tests/
│       └── resources/
│           └── simpleText.txt
├── target/
├── .gitignore
├── pom.xml
├── ReadME.md
├── report.html
└── testng.xml

---



## 📝 Assumptions
- Chrome browser is the default browser for execution
- Internet connectivity is required during test execution

---

## 📊 Evidence

- 📸 *Screenshots* → stored in screenshots/ folder
- 📑 *Reports* → stored in reports/ folder
    - Example: report.html

---
