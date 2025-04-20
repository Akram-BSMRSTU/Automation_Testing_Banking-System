# 🏦 Banking App – Automation Testing (Playwright Java)

## 📋 Project Overview

This project is an automation test suite for a web-based **Banking Application** using **Playwright Java**. The app supports basic banking operations such as Deposit, Withdrawal, Transfer, Add Interest, and Reset functionalities. It also includes transaction history tracking.&#x20;

## 🚀 Tools & Technologies

- **Language**: Java
- **Automation Tool**: Playwright for Java
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Browser**: Firefox ,Chromium,Safari,Chrome(via Playwright)

## 📁 Project Structure

```
project-root
│
├── src
│   ├── main
│   │   └── java
│   │       ├── Factory
│   │       │   └── PlaywrightFactory.java
│   │       └── Pages
│   │           ├── Homepage.java
│   │           ├── LoginPage.java
│   │           ├── SeleniumPracticePage.java
│   │           └── WebAutomationPage.java
│   └── test
│       ├── java
│       │   └── tests
│       │       ├── BaseTest.java
│       │       ├── HomePageTest.java
│       │       ├── LoginPageTest.java
│       │       ├── SeleniumPracticePageTest.java
│       │       └── WebAutomationTest.java
│       └── resources
│           └── testrunner
│               └── testng.xml
│
├── pom.xml
└── README.md
```

## ✅ Test Scenarios Covered

### 🔹 Deposit Functionality

- Enter the amount (e.g., 1000) and click Deposit.
- Verifies if the balance is updated.
- Checks the deposit transaction history.

### 🔹 Withdraw Functionality

- Enter the amount (e.g., 200) and click Withdraw.
- Validates updated balance after withdrawal.
- Checks if the withdrawal is in the transaction history.

### 🔹 Transfer Functionality

- Enter the amount and click Transfer.
- Dialog appears to enter the account number.
- Verifies the amount transfer and entry in the transfer history.

### 🔹 Add Interest Functionality

- Clicks the Add Interest button.
- Verifies that 5% interest is added to the balance.

### 🔹 Reset Account Functionality

- Clicks Reset button.
- The dialog appears with OK and Cancel.
- Accepts dialog and verifies balance is reset to \$0.00.

### 🔹 Transaction History Entry

- Validates history list for new transactions like deposit or transfer.
- XPaths used to verify dynamic list entries with partial text matching.

## ⚙️ Page Object Model (POM)

Implemented using a `HomePage` class that includes:

- DepositMoney(String amount)
- DepositmoneyEntryVisible()
- withdrawMoney(String amount)
- WithdrawHistoryVisible()
- transferMoney(String amount, String accountNumber)
- resetAccount()
- addInterest()
- getBalance()
- isTransferSuccessful()
- depositEntryVisible()

## 🔍 Sample Locator Handling

### Handling Prompt for Transfer

```java
page.onceDialog(dialog -> {
    dialog.accept("12345678"); // Enter account number
});
```

### Handling Confirm Dialog for Reset

```java
page.onceDialog(dialog -> dialog.accept());
```

## 📌 Notes

- XPath is used to select dynamic elements like transaction entries:

```xpath
//li[contains(text(),'Deposit of $1000')]
```

- Used `contains()` and `normalize-space()` for stable matching.
- Waits are added where needed using `waitForTimeout()` or proper Playwright waits.

## 📂 How to Run Tests

1. Clone the repository.
2. Install dependencies via Maven.
3. Run tests via TestNG:

```sh
mvn test
```

## 📓 Author

Automation developed by Akram Khan using Playwright Java based on real Banking App features.


