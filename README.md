# Team 7 Project Documentation

## Overview

The School of Advanced Technology is developing a project management system based on **web solutions** to address current efficiency challenges in managing project courses. The existing manual system is inefficient and difficult to scale, leading to organizational and monitoring issues. The new system will streamline the input of **organizations**, project classification, and tracking, with features such as user registration, project submission, viewing, editing, and evaluation. Developed using **Java, HTML, CSS, and MySQL**, the system will be deployed on **Microsoft Azure** in collaboration with the CDO team, focusing on security and scalability. Automation will reduce paper usage, increase administrative efficiency, and contribute to environmental sustainability, while also improving long-term efficiency and scalability.
## Table of Contents

- [Backend](#backend)
    - [Technologies Used](#technologies-used)
    - [Setup Instructions](#setup-instructions)
    - [Project Structure](#project-structure)
    - [API Endpoints](#api-endpoints)
- [Frontend](#frontend)
    - [Technologies Used](#technologies-used-1)
    - [Setup Instructions](#setup-instructions-1)
    - [Project Structure](#project-structure-1)
- [Database Migrations](#database-migrations)
- [Contributing](#contributing)
- [License](#license)

## Backend

### Technologies Used

- Java
- Spring Boot
- Spring Security
- JPA/Hibernate
- MySQL
- Flyway
- Dotenv

### Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/algonquin-college-sat/cst8319-25w-320-team-7.git
cd cst8319-25w-320-team-7/backend
```

2. Create a `.env` file in the root directory and add the following variables:

```env
# Application name
SPRING_APPLICATION_NAME=team7

# Database settings
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/team7
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root

# Flyway settings
SPRING_FLYWAY_ENABLED=true
SPRING_FLYWAY_LOCATIONS=classpath:db/migration
SPRING_FLYWAY_BASELINE_ON_MIGRATE=true

# API Security
API_SECURITY_TOKEN_SECRET=team7

# Server settings
SERVER_ERROR_INCLUDE_STACKTRACE=never
```

3. Build and run the application:

```bash
mvn spring-boot:run
```

### Project Structure

- `src/main/java/com/algonquincollege/team7/`: Contains the main application code.
    - `controller/`: REST controllers for handling HTTP requests.
    - `dto/`: Data Transfer Objects for request and response payloads.
    - `model/`: Entity classes representing the database tables.
    - `repository/`: JPA repositories for data access.
    - `service/`: Business logic and services.
- `src/main/resources/`: Configuration files and static resources.
    - `application.properties`: Application configuration.

### API Endpoints

#### Login

**POST** `/api/login`

Request Body:

```json
{
  "email": "user@example.com",
  "password": "yourpassword"
}
```

Response:

```json
{
  "token": "your-jwt-token"
}
```

#### Signup

**POST** `/api/signup`

Request Body:

```json
{
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe",
  "organizationName": "Org",
  "phone": "1234567890",
  "type": "ORGANIZATION",
  "password": "yourpassword"
}
```

Response:

```json
{
  "userName": "user@example.com",
  "message": "User registered successfully"
}
```


## Frontend

### Technologies Used

- HTML
- CSS
- JavaScript

### Setup Instructions

1. Navigate to the frontend directory:

```bash
cd cst8319-25w-320-team-7/fron
```

- `css/`: Stylesheets for the application.
- `js/`: JavaScript files for application logic.

## Database Migrations

Flyway is enabled by default. Ensure your migration scripts are placed in `src/main/resources/db/migration`.

## License

This project is licensed under the MIT License.

