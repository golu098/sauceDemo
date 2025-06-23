# 🧪 SauceDemo E-Commerce Automation Testing

This project is an end-to-end automation test suite for the [SauceDemo](https://www.saucedemo.com/) e-commerce website using **Java**, **Selenium WebDriver**, and **TestNG**.

## 🔍 About the Site

**SauceDemo** is a demo e-commerce platform used to test automation skills. It offers functionalities like login, adding items to cart, checkout, and more.

## ✅ Features Covered

- 🔐 Login (valid/invalid)
- 📦 Product Listing (verify sorting, names, prices)
- 🛒 Cart Functionality (add, remove, verify items)
- 💳 Checkout Flow (user info, order summary, complete order)
- 🚪 Logout and session validation

## 🧰 Tech Stack

| Tool/Library      | Purpose                      |
|------------------|------------------------------|
| Java              | Programming language         |
| Selenium WebDriver| Browser automation           |
| TestNG            | Test framework               |
| Maven             | Dependency management        |
| Page Object Model | Clean code structure         |
| ExtentReports / Allure (optional) | Reporting |


## 🔑 Test Credentials

Use the following credentials (provided by SauceDemo):

- **Username**: `standard_user`
- **Password**: `secret_sauce`

Other test users include:
- `locked_out_user` → to test invalid access
- `problem_user`, `performance_glitch_user` → for error scenarios

---

## 🚀 How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/saucedemo-automation.git
cd saucedemo-automation
