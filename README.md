# Faculty Management System (Production Build)

A full-stack secure application for managing faculty profiles, deployed on Cloud infrastructure.

## 🚀 Live Demo
**[Launch Application](https://faculty-management-system-9yme.onrender.com/faculty/login)**
*(Note: Hosted on Render Free Tier. Please allow 30-50 seconds for the server to wake up.)*

## 🛠 Tech Stack
* **Backend:** Java 17, Spring Boot 3 (MVC, Data JPA, Hibernate)
* **Database:** MySQL (Cloud Hosted)
* **Frontend:** JSP, CSS, JavaScript (Client-side validation)
* **DevOps:** Render PaaS, UptimeRobot Monitoring
* **Key Features:**
    * Secure Session-based Authentication
    * Base64 Image Serialization for stateless profile picture storage
    * Dynamic Search & Filtering
    * Defensive Programming (File size validation, Input sanitization)

## ⚙️ Local Setup
1.  Clone the repository:
    ```bash
    git clone [https://github.com/Divyesh172/faculty-management-system.git](https://github.com/Divyesh172/faculty-management-system.git)
    ```
2.  Configure Database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/faculty_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```
3.  Run the application:
    ```bash
    mvn spring-boot:run
    ```
