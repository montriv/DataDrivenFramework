# Selenium Data-Driven Automation Framework (POM)

## Project Overview
This project is a **Selenium automation framework** built using **Java**, **TestNG**, and **Apache POI**, following **OOP principles** and the **Page Object Model (POM)** design pattern.

The framework automates the **Automation Practice Form** and reads all test data dynamically from an **Excel file**.

🔗 Application Under Test:  
https://demoqa.com/automation-practice-form

---

## Tech Stack
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Apache POI (Excel)**
- **Maven**
- **Page Object Model (POM)**

---
## Project Structure

```text
DataDrivenFramework
│
├── pom.xml
├── testdata
│   └── PracticeFormData.xlsx
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       │   └── BaseTest.java
│   │       ├── pages
│   │       │   └── PracticeFormPage.java
│   │       └── utils
│   │           └── ExcelUtils.java
│   │
│   └── test
│       └── java
│           └── tests
│               └── PracticeFormTest.java
```
### Data-Driven Testing
- Test data is stored in **Excel**
- Apache POI is used to read data
- TestNG `@DataProvider` feeds data into tests

## Test Execution Flow
1. Read test data from Excel
2. Launch browser
3. Fill all form fields dynamically
4. Submit the form
5. Close browser

## How to Run the Project
1. Clone the repository
   ```bash
   git clone https://github.com/montriv/DataDrivenFramework.git
