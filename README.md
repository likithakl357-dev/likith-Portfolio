# Likith Charan — Engineering Portfolio

A responsive dark-theme portfolio built with **Java 21, Spring Boot, HTML, CSS, and JavaScript**.

## Features
- Responsive navigation and layouts
- Project cards loaded from a Spring Boot REST endpoint
- Project search and category filters
- About, skills, education, experience, and contact sections
- Reduced-motion support and basic accessibility labels
- Direct links to GitHub repositories, LinkedIn, and email

## Requirements
- Java 21+
- Maven 3.9+ (or an IDE with Maven support)

## Run locally
From the project root:

```bash
mvn spring-boot:run
```

Open http://localhost:8080.

To build an executable JAR:

```bash
mvn clean package
java -jar target/likith-portfolio-1.0.0.jar
```

## API
- `GET /api/health` — basic application health response
- `GET /api/projects` — portfolio project data in JSON

## Before publishing
- Verify each repository link and project description.
- Add a resume file and link only when ready.
- Review the HL Mando experience summary to ensure it accurately reflects your duties.
- Confirm whether your repository URLs ending in a hyphen are correct; if not, update them in `PortfolioController.java`.
- Add real project screenshots and implementation results when available.
- Do not publish private data or credentials.

## Deployment
This project requires a Java-capable host for the Spring Boot backend. A static-only host cannot run the Java application without a separate API deployment.
