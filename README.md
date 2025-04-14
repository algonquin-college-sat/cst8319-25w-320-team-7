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
    - [Project Structure](#project-structure)
- [Database Migrations](#database-migrations)
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

2. Create a `.env` file in the directory backend/src/main/resources and add the following variables:

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

3. Build the database inside MySql:

```sql
create database team7;
```

4. Build and run the application:

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

| Method   | Endpoint                                  | Description                              | Details                                                             |
|----------|-------------------------------------------|------------------------------------------|---------------------------------------------------------------------|
| `POST`   | `/api/login`                             | User authentication.                     | [🔐 Login](api.md#login)                                            | 
| `POST`   | `/api/signup`                            | New user registration.                   | [📝 Signup](api.md#signup)               |
| `POST`   | `/api/project`                           | Create a new project.                    | [📦 Project Registration](api.md#project-registration)              |
| `PUT`    | `/api/project`                           | Update an existing project.              | [✏️ Project Update](api.md#project-update)                          |
| `GET`    | `/api/project/{id}`                      | View project details.                    | [🔍 Project View](api.md#project-view)                              |
| `GET`    | `/api/project/organization/{id}`         | List projects by organization.      | [📋 Project List](api.md#project-list)                              |
| `POST`   | `/api/project/validation`                | Professor project validation.            | [✅ Validation Registration](api.md#project-validation-registration) |
| `PUT`    | `/api/project/validation`                | Update validation by professor.          | [🛠️ Validation Update](api.md#project-validation-update)           |
| `POST`   | `/api/project/tag`                       | Add a tag to a project.                  | [🏷️ Tag Registration](api.md#project-tag-registration)             |
| `DELETE` | `/api/project/tag/{tagId}`               | Remove a project tag.                    | [❌ Tag Exclusion](api.md#project-tag-exclusion)                     |

**📌 For parameters and examples, see the full [API Documentation](api.md#api-endpoints).**

### Admin API Endpoints

| Method | Endpoint                   | Description                   | Details                                                  |
|--------|----------------------------|-------------------------------|----------------------------------------------------------|
| `POST` | `/api/tag_type`            | Tag type registration.        | [✅ Tag Type Registration](api.md#tag-type-registration)  | 
| `PUT`  | `/api/tag_type`            | Update an existing tag type.  | [🛠️ Tag Type Update](api.md#tag-type-update)            |
| `POST` | `/api/tag_value`           | Tag value registration.       | [✅ Tag Value Registration](api.md#tag-value-registration) |
| `PUT`  | `/api/tag_value`           | Update an existing tag value. | [🛠️ Tag Value Update](api.md#tag-value-update)          |
| `GET`  | `/api/tag_value`           | List available tags.          | [📋 Tag Type/Value List](api.md#tag-typevalue-list)      |

## Frontend

### Technologies Used

- HTML
- CSS
- JavaScript

### Setup Instructions

1. Navigate to the frontend directory:

```bash
cd cst8319-25w-320-team-7/frontend
```

- `css/`: Stylesheets for the application.
- `js/`: JavaScript files for application logic.

## Database Migrations

Flyway is enabled by default. Ensure your migration scripts are placed in `backend/src/main/resources/db/migration`.

- [How to change the database](flyway.md)
- [Flyway tutorial](https://flywaydb.org/documentation/)

## License

This project is licensed under the MIT License.
