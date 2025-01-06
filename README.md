
# Puppies Social Media API

This project is a social media API for managing users, posts, and likes. It is built using Java, Spring Boot, and Maven, with a PostgreSQL database.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
  - [User Endpoints](#user-endpoints)
  - [Post Endpoints](#post-endpoints)
  - [Like Endpoints](#like-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/puppies-social-media-api.git
   cd puppies-social-media-api
   ```

2. Set up the PostgreSQL database and update the `application.properties` file with your database credentials.

3. Build the project using Maven:
   ```sh
   mvn clean install
   ```

4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage

You can use Postman or any other API client to interact with the API. The base URL for the API is `http://localhost:8080`.

## Endpoints

### User Endpoints

- **Create User**
  - **URL:** `/users/create`
  - **Method:** `POST`
  - **Request Body:**
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "password": "password123"
    }
    ```
  - **Response:**
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "createdAt": "2023-01-01T00:00:00"
    }
    ```

- **Get User by ID**
  - **URL:** `/users/getbyid/{userId}`
  - **Method:** `GET`
  - **Response:**
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "createdAt": "2023-01-01T00:00:00"
    }
    ```

### Post Endpoints

- **Create Post**
  - **URL:** `/posts/create`
  - **Method:** `POST`
  - **Request Body:**
    ```json
    {
      "content": "This is a new post",
      "imageUrl": "http://example.com/image.jpg",
      "authorId": 1
    }
    ```
  - **Response:**
    ```json
    {
      "id": 1,
      "content": "This is a new post",
      "imageUrl": "http://example.com/image.jpg",
      "createdAt": "2023-01-01T00:00:00",
      "author": {
        "id": 1,
        "name": "John Doe"
      }
    }
    ```

- **Get Post by ID**
  - **URL:** `/posts/getbyid/{postId}`
  - **Method:** `GET`
  - **Response:**
    ```json
    {
      "id": 1,
      "content": "This is a new post",
      "imageUrl": "http://example.com/image.jpg",
      "author": {
        "id": 1,
        "name": "John Doe"
      }
    }
    ```

- **Get Feed**
  - **URL:** `/posts/feed`
  - **Method:** `GET`
  - **Query Parameters:**
    - `page` (default: 0)
    - `size` (default: 10)
  - **Response:**
    ```json
    {
      "content": [
        {
          "id": 1,
          "content": "This is a new post",
          "imageUrl": "http://example.com/image.jpg",
          "createdAt": "2023-01-01T00:00:00",
          "author": {
            "id": 1,
            "name": "John Doe"
          }
        }
      ],
      "pageable": {
        "pageNumber": 0,
        "pageSize": 10
      },
      "totalPages": 1,
      "totalElements": 1
    }
    ```

### Like Endpoints

- **Like a Post**
  - **URL:** `/likes/likeapost`
  - **Method:** `POST`
  - **Request Body:**
    ```json
    {
      "userId": 1,
      "postId": 1
    }
    ```
  - **Response:**
    ```json
    {
      "id": 1,
      "user": {
        "id": 1,
        "name": "John Doe"
      },
      "post": {
        "id": 1,
        "content": "This is a new post"
      },
      "likedAt": "2023-01-01T00:00:00"
    }
    ```

- **Get Liked Posts by User ID**
  - **URL:** `/likes/likedpostsbyuser/{userId}`
  - **Method:** `GET`
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "content": "This is a new post",
        "imageUrl": "http://example.com/image.jpg",
        "createdAt": "2023-01-01T00:00:00",
        "author": {
          "id": 1,
          "name": "John Doe"
        }
      }
    ]
    ```

## Database Schema

The database schema includes the following tables:


 **users**
  - `id` (Primary Key)
  - `name`
  - `email`
  - `password`
  - `created_at`


 **posts**
  - `id` (Primary Key)
  - `content`
  - `image_url`
  - `created_at`
  - `author_id` (Foreign Key to `users` table)


 **likes**
  - `id` (Primary Key)
  - `user_id` (Foreign Key to `users` table)
  - `post_id` (Foreign Key to `posts` table)
  - `liked_at`


## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
