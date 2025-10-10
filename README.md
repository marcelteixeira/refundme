# 💸 refundMe — Reimbursement Management System

> A modern Spring Boot web application for submitting and managing reimbursement requests with real-time email notifications.



---

## 🚀 Overview

**refundMe** is a backend-driven web application developed with **Spring Boot**, **Thymeleaf**, and **Bootstrap 5**, designed to manage reimbursement requests within an organization.

The system allows users to:
- Submit reimbursement requests through a web form
- Persist the data in a **MySQL** database
- Automatically send a **styled HTML email** with the request details to the company’s HR department

This project demonstrates full-stack backend integration — from form submission to database persistence and email delivery — and serves as a strong portfolio example for enterprise-grade Spring Boot development.

---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Java 21, Spring Boot 3.3 |
| **View** | Thymeleaf, Bootstrap 5.3 |
| **Database** | MySQL (JDBC connection via `ConnectionFactory`) |
| **Mail Service** | Spring Boot Starter Mail (`JavaMailSender`) |
| **Template Engine** | Thymeleaf with server-side rendering |
| **Testing SMTP** | Mailtrap (sandbox email delivery) |

---

## 📂 Project Structure

```
src/
 ├── main/
 │   ├── java/it/wisecore/refundme/
 │   │   ├── controllers/ → MVC Controllers
 │   │   ├── models/ → Entities & Database operations
 │   │   ├── services/ → Business logic (e.g., EmailService)
 │   │   └── RefundMeApplication.java
 │   └── resources/
 │       ├── templates/ → Thymeleaf HTML pages
 │       ├── static/ → CSS & JS
 │       └── application.properties → App configuration
 └── test/ → Unit tests (future scope)
```

---

## 🧱 Key Features

✅ Clean MVC architecture with Thymeleaf integration  
✅ Responsive UI built with Bootstrap 5  
✅ Data persistence using JDBC and MySQL  
✅ Automatic HTML email sending with JavaMailSender  
✅ Dynamic text blocks for formatted email templates  
✅ Centralized database connection via ConnectionFactory  
✅ Secure configuration using `application.properties`

---

## 📨 Email Example

The system automatically sends a professional HTML email like this:

![Mailtrap Example](docs/screenshot-mailtrap.png)

**Email Content Example:**

```html
<div style="max-width: 600px; margin:auto; font-family: Arial;">
  <h2 style="background-color:#2563eb; color:white; padding:12px; border-radius:6px 6px 0 0;">
    New Reimbursement Request
  </h2>
  <div style="padding:20px; border:1px solid #ddd;">
    <p>A new reimbursement request has been submitted with the following details:</p>
    <p><b>Name:</b> Marcel Mofati Teixeira</p>
    <p><b>Email:</b> marcel@m1project.com.br</p>
    <p><b>Requested Amount:</b> $100.00</p>
    <p><b>Message:</b> Travel expenses</p>
  </div>
  <div style="background-color:#f1f1f1; text-align:center; padding:10px;">
    &copy; 2025 WiseCore IT — refundMe
  </div>
</div>
```

---

## ⚙️ Configuration

Update your `application.properties` file:

```properties
# Server
server.port=8080

# MySQL Database
spring.datasource.url=jdbc:mysql://localhost:3306/refundme
spring.datasource.username=root
spring.datasource.password=yourpassword

# Mailtrap Configuration
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=587
spring.mail.username=YOUR_MAILTRAP_USER
spring.mail.password=YOUR_MAILTRAP_PASS
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## 🧠 Learning Highlights

This project demonstrates:
- Backend form handling with Spring MVC  
- Sending styled HTML emails using **JavaMailSender**  
- Building maintainable MVC applications with **Spring Boot 3**  
- Using Java Text Blocks (`"""`) and `.formatted()` for dynamic HTML generation  
- Clean architecture following service and controller layers separation  

---

## 🧩 Future Enhancements

🔹 Add login/authentication for employees and HR staff  
🔹 Add approval workflow (Approve / Decline requests)  
🔹 Store attachments (e.g., receipts) in database or S3  
🔹 Add email notifications for both sender and approver  
🔹 Add API endpoints for external integration  

---

## 👨‍💻 Author

**Marcel Mofati Teixeira**  
📍 San Diego, CA  
💼 [LinkedIn](https://www.linkedin.com/in/marcelmofati)  
💻 [GitHub](https://github.com/marcelmofati)

---


> “Technology is not just about automation — it’s about enabling people to do their best work.”  
> — *Marcel Mofati, WiseCore IT*
