# 📔 Journal App

A secure, feature-rich journal application built with Spring Boot and MongoDB that allows users to create, manage, and organize their personal journal entries with JWT authentication and sentiment analysis capabilities.

## 🚀 Features

- **User Authentication & Authorization**: Secure JWT-based authentication system with role-based access control (USER, ADMIN)
- **Journal Entry Management**:  Create, read, update, and delete personal journal entries
- **MongoDB Integration**: Persistent storage using MongoDB with transaction support
- **Spring Security**:  Comprehensive security implementation with password encryption (BCrypt)
- **RESTful API**: Well-structured REST endpoints for all operations
- **Weather Integration**:  Get weather information for specific cities
- **Sentiment Analysis**: Optional sentiment analysis feature for journal entries
- **API Documentation**: Integrated Swagger UI for easy API exploration and testing
- **Logging**: Comprehensive logging for debugging and monitoring

## 🛠️ Technology Stack

- **Framework**: Spring Boot 2.7.16
- **Language**: Java 11
- **Database**: MongoDB
- **Security**: Spring Security + JWT (JSON Web Tokens)
- **Build Tool**: Maven
- **API Documentation**: Swagger/OpenAPI 3.0 (springdoc-openapi-ui)
- **Code Simplification**:  Lombok
- **Testing**: JUnit

## 📋 Prerequisites

Before running this application, ensure you have: 

- Java 11 or higher installed
- MongoDB instance (local or MongoDB Atlas)
- Maven 3.6+ installed
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

## ⚙️ Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/Himanshu0508Raturi/journalApp.git
cd journalApp/journalApp
```

### 2. Configure MongoDB

Update your MongoDB connection settings in `application.properties` or `application.yml`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journalApp
# or for MongoDB Atlas
# spring. data. mongodb.uri=mongodb+srv://<username>:<password>@cluster. mongodb.net/journalApp
```

### 3. Build the project

```bash
./mvnw clean install
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

Once the application is running, access the Swagger UI at: 

```
http://localhost:8080/swagger-ui. html
```

### Main API Endpoints

#### Authentication

- `POST /public/signup` - Register a new user
- `POST /public/login` - Authenticate and receive JWT token

#### Journal Entries

- `POST /journal` - Create a new journal entry
- `GET /journal` - Get all journal entries for authenticated user
- `GET /journal/id/{id}` - Get specific journal entry by ID
- `PUT /journal/id/{id}` - Update a journal entry
- `DELETE /journal/id/{id}` - Delete a journal entry

#### User Management

- `GET /user` - Get user information
- `PUT /user` - Update user profile
- `DELETE /user` - Delete user account
- `GET /user/{city}` - Get weather information for a city

## 🔐 Security

This application implements multiple layers of security: 

1. **Password Encryption**: All passwords are encrypted using BCryptPasswordEncoder
2. **JWT Authentication**:  Stateless authentication using JSON Web Tokens
3. **Role-Based Access**: Different access levels for USER and ADMIN roles
4. **Unique Username**: Enforced unique usernames with MongoDB indexing

## 🏗️ Project Structure

```
journalApp/
├── src/main/java/net/engineeringdigest/journalApp/
│   ├── controller/         # REST API controllers
│   ├── entity/            # MongoDB entity models (User, JournalEntry)
│   ├── repository/        # MongoDB repositories
│   ├── services/          # Business logic layer
│   ├── Utilities/         # Utility classes (JWT, etc.)
│   └── JournalApplication.java
├── src/main/resources/
│   └── application.properties
├── src/test/             # Unit and integration tests
└── pom.xml              # Maven dependencies
```

## 📦 Key Dependencies

```xml
<!-- Core Spring Boot -->
spring-boot-starter-web
spring-boot-starter-security
spring-boot-starter-data-mongodb

<!-- JWT Authentication -->
jjwt-api, jjwt-jackson, jjwt-impl (v0.12.5)

<!-- Code Generation -->
lombok (v1.18.38)

<!-- API Documentation -->
springdoc-openapi-ui (v1.7.0)
```

## 🧪 Testing

Run tests using: 

```bash
./mvnw test
```

## 📝 Features in Detail

### Transaction Management

The application uses MongoDB transactions for critical operations:

- Creating journal entries with user association
- Deleting journal entries with user reference cleanup

**Note**:  Transactions require MongoDB replica sets (works with MongoDB Atlas by default)

### Sentiment Analysis

Users can opt-in for sentiment analysis of their journal entries by setting `sentimentAnalysis: true` in their user profile.

### Weather Integration

Get current weather information for any city to add context to your journal entries.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is created for educational purposes.

## 👤 Author

**Himanshu Raturi**

- GitHub: [@Himanshu0508Raturi](https://github.com/Himanshu0508Raturi)

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- MongoDB for providing a flexible NoSQL database
- Engineering Digest for project inspiration

---
## Developed By- Himanshu Raturi [![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/himanshu-raturi/)
**Note**: This is a learning project demonstrating Spring Boot best practices, security implementation, and MongoDB integration. Feel free to use it as a reference for your own projects! 
