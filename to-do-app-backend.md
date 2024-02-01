# Todo App Backend Project

## Database Schema

### TodoList
- `id` (Primary Key): A unique identifier for each todo list.
- `name`: The name of the todo list.
- `description`: A brief description of the todo list.
- `created_at`: Timestamp of creation.
- `updated_at`: Timestamp of the last update.

### TodoItem
- `id` (Primary Key): A unique identifier for each todo item.
- `todo_list_id` (Foreign Key): References `id` in `TodoList`.
- `content`: The content of the todo item.
- `is_completed`: A boolean to indicate if the item is completed.
- `created_at`: Timestamp of creation.
- `updated_at`: Timestamp of the last update.

## API Specification

### Base URL: `/api`

#### Endpoints:

**1. TodoList Management**

- **Create TodoList**
  - **Endpoint**: `/todolists`
  - **Method**: POST
  - **Request Body**:
    ```json
    {
      "name": "String",
      "description": "String"
    }
    ```
  - **Response**: TodoList object with HTTP Status 201 (Created).

- **Get All TodoLists**
  - **Endpoint**: `/todolists`
  - **Method**: GET
  - **Response**: Array of TodoList objects with HTTP Status 200 (OK).

- **Update TodoList**
  - **Endpoint**: `/todolists/{id}`
  - **Method**: PUT
  - **Request Body**:
    ```json
    {
      "name": "String",
      "description": "String"
    }
    ```
  - **Response**: Updated TodoList object with HTTP Status 200 (OK).

- **Delete TodoList**
  - **Endpoint**: `/todolists/{id}`
  - **Method**: DELETE
  - **Response**: HTTP Status 204 (No Content).

**2. TodoItem Management**

- **Create TodoItem**
  - **Endpoint**: `/todolists/{listId}/items`
  - **Method**: POST
  - **Request Body**:
    ```json
    {
      "content": "String",
      "is_completed": "Boolean"
    }
    ```
  - **Response**: TodoItem object with HTTP Status 201 (Created).

- **Get All TodoItems in a List**
  - **Endpoint**: `/todolists/{listId}/items`
  - **Method**: GET
  - **Response**: Array of TodoItem objects with HTTP Status 200 (OK).

- **Update TodoItem**
  - **Endpoint**: `/todolists/{listId}/items/{itemId}`
  - **Method**: PUT
  - **Request Body**:
    ```json
    {
      "content": "String",
      "is_completed": "Boolean"
    }
    ```
  - **Response**: Updated TodoItem object with HTTP Status 200 (OK).

- **Delete TodoItem**
  - **Endpoint**: `/todolists/{listId}/items/{itemId}`
  - **Method**: DELETE
  - **Response**: HTTP Status 204 (No Content).

## Future Expansion Considerations

- User authentication and personalized todo lists.

## Implementation Tips

- Use Spring Boot's RESTful capabilities, JPA, exception handling, Swagger, and unit tests.