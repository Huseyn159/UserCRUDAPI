User CRUD REST API

Simple user management REST API built with Spring Boot.

This project focuses on understanding how a typical backend application is structured using controller, service, and repository layers.

Features

Create, read, update and delete users

RESTful API design

Input validation

Global exception handling

H2 in-memory database

Tech Stack

Java

Spring Boot

Spring Web

Spring Data JPA

Hibernate

H2 Database

Lombok

API Endpoints
POST    /users
GET     /users
GET     /users/{id}
PUT     /users/{id}
DELETE  /users/{id}

Validation & Errors

Invalid input → 400 Bad Request

User not found → 404 Not Found

Duplicate email → 409 Conflict

Running the Project

Run from IDE or using Maven:

./mvnw spring-boot:run


App runs on:

http://localhost:8080

Notes

This project was created for learning purposes to practice Spring Boot REST APIs and backend fundamentals.

Author

Huseyn
