# Zepto Mail API 📧

A Spring Boot-based microservice responsible for sending email notifications within the Zepto clone ecosystem. This service handles communication such as order confirmations, assignments, and delivery updates using HTML templates.

---

## 🔧 Features

- Send order confirmation emails to users
- Notify delivery partners about new assignments
- HTML email templates using Thymeleaf (or raw HTML)
- Built with layered architecture: Controller, Service, DTOs
- Easily integratable with other microservices (Order, Payment)
- Lightweight and stateless Spring Boot service
- Environment-specific configuration using `application.properties`

---

## 🛠️ Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Email API**: JavaMailSender
- **Template Engine**: Thymeleaf (or raw HTML)
- **Build Tool**: Maven
- **Tools**: Postman, Git, IntelliJ / VS Code

---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.mail.zepto.mail_api
│   │       ├── controller              # REST controllers
│   │       ├── service                 # Business logic
│   │       └── requestBody             # DTOs for request/response
│   └── resources
│       ├── templates                   # HTML templates for emails
│       └── application.properties      # Configurations
└── test
    └── java
        └── com.mail.zepto.mail_api    # Unit tests
```

---

## 🚀 How to Run Locally

1. **Clone the repository**
```bash
git clone https://github.com/borrolla/zepto-mail-api.git
cd zepto-mail-api
```

2. **Configure SMTP settings**
Update the following in `src/main/resources/application.properties`:
```properties
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

3. **Build and Run**
```bash
./mvnw spring-boot:run
```

---

## 🔗 Sample Endpoint

```
POST /send-mail
```

**Body (JSON)**:
```json
{
  "email": "customer@example.com",
  "orderId": "ZP123456",
  "products": [...],
  "amount": 599.99
}
```

Returns: `200 OK` on success.

---

## 📬 Contact

Made with 💻 by Sravan Kumar Borrolla  
📧 sravankumarborrolla39@email.com  
🔗 [LinkedIn](https://linkedin.com/in/sravankumarborrolla)
