
# API Endpoints

- [API Endpoints](#api-endpoints)
  - [🔐 Login](#login)
  - [📝 Signup](#signup)
  - [📦 Project Registration](#project-registration)
  - [✏️ Project Update](#project-update)
  - [🔍 Project View](#project-view)
  - [📋 Project List](#project-list)
  - [✅ Project Validation Registration](#project-validation-registration)
  - [🛠️ Project Validation Update](#project-validation-update)
  - [🏷️ Project Tag Registration](#project-tag-registration)
  - [❌ Project Tag Deletion](#project-tag-exclusion)

---

### Login

**POST** `/api/login`

**Request Body:**
```json
{
  "email": "string (valid email address)",
  "password": "string (min. 8 characters)"
}
```

**Response:**
```json
{
  "token": "jwt-token",
  "userId": 42,
  "email": "professor@university.edu",
  "firstName": "Alex",
  "lastName": "Johnson",
  "type": "PROFESSOR"
}
```

---

### Signup

**POST** `/api/signup`

**Request Body:**
```json
{
  "email": "string",
  "firstName": "string",
  "lastName": "string",
  "organizationName": "string",
  "phone": "string",
  "type": "enum (ORGANIZATION, ADMIN, PROFESSOR)",
  "password": "string"
}
```

**Response:**
```json
{
  "userName": "professor@university.edu",
  "message": "User registered successfully"
}
```

---

### Project Registration

**POST** `/api/project`

**Request Body:**
```json
{
  "projectName": "string",
  "description": "string",
  "availableTime": 180,
  "purchasingRequirements": "string",
  "ndaRequired": true,
  "showcaseAllowed": false,
  "semester": "FALL_2025",
  "organizationId": 1
}
```

**Response:**
```json
{
  "message": "Project registered successfully"
}
```

---

### Project Update

**PUT** `/api/project`

**Request Body:**
```json
{
  "id": 1,
  "projectName": "Updated Project Name",
  "description": "Updated description",
  "availableTime": 200,
  "purchasingRequirements": "Updated requirements",
  "ndaRequired": false,
  "showcaseAllowed": true,
  "semester": "SPRING_2026",
  "organizationId": 1
}
```

**Response:**
```json
{
  "message": "Project updated successfully"
}
```

---

### Project View

**GET** `/api/project/{idProject}`

**Response:**
```json
{
  "id": 1,
  "projectName": "AI Learning Platform",
  "description": "An adaptive learning system using machine learning...",
  "availableTime": 180,
  "purchasingRequirements": "Cloud GPU credits",
  "ndaRequired": true,
  "showcaseAllowed": false,
  "semester": "FALL_2025",
  "createdAt": "2025-04-01T21:15:45Z",
  "updatedAt": null,
  "professorFeedback": "Focus on accessibility features in MVP",
  "tags": [
    {"id": 1, "value": "Machine Learning"},
    {"id": 2, "value": "Education"},
    {"id": 3, "value": "Python"}
  ]
}
```

---

### Project List

**GET** `/api/project/organization/{idOrganization}`

**Response:**
```json
{
  "projects": [
    {
      "id": 1,
      "projectName": "AI Research Platform",
      "description": "Machine learning infrastructure project...",
      "semester": "FALL_2025",
      "ndaRequired": true,
      "showcaseAllowed": false,
      "createdAt": "2025-04-01T21:15:45Z",
      "tags": [
        {"id": 1, "value": "Machine Learning"},
        {"id": 2, "value": "Python"}
      ]
    },
    {
      "id": 2,
      "projectName": "E-Commerce Backend",
      "description": "Scalable payment system...",
      "semester": "SPRING_2026",
      "ndaRequired": false,
      "showcaseAllowed": true,
      "createdAt": "2025-04-02T10:30:00Z",
      "tags": [
        {"id": 3, "value": "Java"},
        {"id": 4, "value": "Microservices"}
      ]
    }
  ],
  "page": 0,
  "size": 10,
  "totalElements": 3,
  "totalPages": 1
}
```

---

### Project Validation Registration

**POST** `/api/project/validation`

**Request Body:**
```json
{
  "projectId": 1,
  "professorId": 2,
  "professorFeedback": "Detailed feedback here"
}
```

**Response:**
```json
{
  "message": "Validation registered successfully"
}
```

---

### Project Validation Update

**PUT** `/api/project/validation`

**Request Body:**
```json
{
  "projectId": 1,
  "professorId": 2,
  "professorFeedback": "Updated feedback"
}
```

**Response:**
```json
{
  "message": "Validation edited successfully"
}
```

---

### Project Tag Registration

**POST** `/api/project/tag`

**Request Body:**
```json
{
  "projectId": 1,
  "tagValueId": 3,
  "professorId": 2
}
```

**Response:**
```json
{
  "message": "Tag registered successfully"
}
```

---

### Project Tag Exclusion

**DELETE** `/api/project/tag/{tagId}`

**Response:**
```json
{
  "message": "Tag deleted successfully"
}
```

---


