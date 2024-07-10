# Employee Management System

This project is a simple Employee Management System built with Angular for the frontend and Spring Boot for the backend. The application allows you to view, add, edit, and delete employees.

## Prerequisites

- Docker
- Docker Compose (optional)
- Node.js v20.14.0
- Java 17

## Getting Started

### Backend

1. **Navigate to the backend directory:**
```bash
cd backend
```
2. Build the backend application:
```bash
 ./mvnw clean package
 ```
 3. Run the backend application:
```bash
java -jar target/employee-service-0.0.1-SNAPSHOT.jar
```

### Frontend

1. Navigate to the frontend directory:
```bash
cd frontend
```
2. Install dependencies:
```bash
npm install
```
3. Build the frontend application:
```bash
npm run build
```
4. Run the frontend application:
```bash
npm start
```

### Running with Docker

#### Backend

1. Build the backend Docker image:
```bash
docker build -t hussain50/employee-service .
```
2. Run the backend Docker container:
```bash
docker run -p 8080:8080 hussain50/employee-service
```

#### Frontend

1. Build the frontend Docker image:
```bash
docker build -t hussain50/employee-frontend .
```
2. Run the frontend Docker container:
```bash
docker run -p 80:80 your-dockerhub-username/employee-frontend
```

#### API Endpoints
- GET /employees - Get all employees
- GET /employees/{id} - Get an employee by ID
- POST /employees - Add a new employee
- PUT /employees/{id} - Update an employee
- DELETE /employees/{id} - Delete an employee

#### Frontend Routes
- / - Employee list
- /add - Add employee
- /edit/{id} - Edit employee
- /view/{id} - View employee

### DockerHub Images
Backend: hussain50/employee-service
Frontend: hussain50/employee-frontend


### How to Build and Run the Application Locally

#### Backend

1. Navigate to the backend directory
2. Build the backend application
3. Run the backend application

```bash
cd backend
./mvnw clean package
java -jar target/employee-service-0.0.1-SNAPSHOT.jar
```

#### Frontend

1. Navigate to the frontend directory
2. Install dependencies
3. Build the frontend application
4. Run the frontend application

```bash
cd frontend
npm install
npm run build
npm start
```
