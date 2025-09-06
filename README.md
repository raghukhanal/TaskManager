# Task Manager

A full-stack application built with **Spring Boot** (backend) and **React** (frontend, using Vite).

## Features
- Task creation, editing, and deletion
- Task status tracking

## Tech Stack

- **Backend:** Java, Spring Boot
- **Frontend:** React, Vite
- **Build Tools:** Maven/Gradle, npm/yarn

## Getting Started

### Backend (Spring Boot)

1. **Install dependencies:**
    ```bash
    ./mvnw clean install
    ```
2. **Run the server:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The backend runs on `http://localhost:8080`.

### Frontend (React + Vite)

1. **Navigate to the frontend directory:**
    ```bash
    cd task-manager-frontend
    ```
2. **Install dependencies:**
    ```bash
    npm install
    ```
3. **Start the development server:**
    ```bash
    npm run dev
    ```
    The frontend runs on `http://localhost:5173`.

## API Endpoints

- `GET /api/tasks` - List all tasks
- `POST /api/tasks` - Create a new task
- `PUT /api/tasks/{id}` - Update a task
- `DELETE /api/tasks/{id}` - Delete a task

## Project Structure

```
task-manager/
├── # Spring Boot application
└── src/main/frontend/     # React + Vite application
```

## License

MIT