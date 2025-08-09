# Architecture Overview

## System Components
1. **Frontend**: Vue.js web application
2. **Backend**: Java EE REST API
3. **Database**: MySQL 8.0
4. **Chatbot**: Rasa/Dialogflow integration

## Data Flow
```mermaid
graph TD
    A[User] --> B[Frontend]
    B --> C[Backend API]
    C --> D[(Database)]
    B --> E[Chatbot]
    E --> C