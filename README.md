# Spring Security Demo – JWT Authentication & CSRF Handling

This is a demo Spring Boot project showcasing the fundamentals of Spring Security, including JWT-based authentication, CSRF handling, and secure API access. It's aimed at developers looking to understand how to build a stateless authentication system using Spring Security.

## 🚀 Features

- 🔐 Spring Security configuration with filter chain
- 🛡️ CSRF (Cross-Site Request Forgery) protection explained and controlled
- 🔑 JWT (JSON Web Token) generation and validation
- 👤 Custom user authentication
- ⚙️ Stateless session management using JWTs
- 📜 Clean and understandable code for learning and extension

## 📚 What You’ll Learn

- How Spring Security intercepts and secures requests
- How to disable or enable CSRF protection based on use case
- How to generate a JWT securely and return it on login
- How to validate incoming JWT tokens for secure access
- How to use filters to intercept and process requests

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security
- JWT (via `jjwt` library)
- Maven

## 📁 Project Structure

```
src
└── main
    ├── java
    │   └── com.example.securitydemo
    │       ├── config          # Security configurations
    │       ├── controller      # Test endpoints
    │       ├── filter          # JWT filter
    │       ├── model           # User model (if applicable)
    │       ├── service         # JWT service and user details service
    │       └── SecurityDemoApplication.java
    └── resources
        └── application.properties
```

## 🧪 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/manoharvallabi/SpringSecurityDemo.git
   cd SpringSecurityDemo
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Test the API (e.g., using Postman):
   - `POST /register` — to register
   - `POST /login` — to authenticate and get a JWT
   - `GET /students` — secured endpoint (pass JWT in Authorization header)

## 🔐 Example JWT Flow

1. User logs in with username/password
2. Server authenticates and returns a signed JWT
3. Client stores and sends JWT in `Authorization: Bearer <token>` header
4. Server validates token signature and expiration before granting access

## 🔄 CSRF Handling

- CSRF is disabled for stateless APIs using JWT (`http.csrf().disable()`)
- For web-based logins, CSRF can be enabled and the token extracted via templates or meta tags

## 📦 Dependencies

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```

## 📄 License

This project is for educational and demonstration purposes.

---

Feel free to fork, clone, and build on top of it!
