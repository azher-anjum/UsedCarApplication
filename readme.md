# Used Car Management System (DevSecOps)

A full-stack Spring Boot application built with Java 21 and JSP, designed with a complete DevSecOps pipeline.

## 🚀 Features
* **Backend:** Spring Boot 3+ (Java 21)
* **Frontend:** JSP (Java Server Pages)
* **Database:** MySQL / H2
* **Code Quality:** SonarQube integrated
* **Containerization:** Docker (Multi-stage builds)
* **IaC:** Terraform for Kubernetes deployment

## 🛠️ How to Run Locally
1. Clone the repo: `git clone <your-repo-url>`
2. Build the image: `docker build -t used-car-app .`
3. Run via Docker Compose: `docker-compose up`

## 🛡️ Security & Quality
* Static analysis performed via SonarQube.
* Image scanning performed via Trivy.