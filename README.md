# Spring Boot Microservices – Learning Project

A **Spring Boot Microservices architecture project** built for learning modern backend system design and cloud-native development.

This project demonstrates how to build a **scalable microservices-based system** using Spring Cloud ecosystem, event-driven architecture, and modern DevOps tools.

---

## Tech Stack

- Java
- Spring Boot
- Spring Cloud
- Eureka Discovery Server
- Spring Cloud Config Server
- API Gateway
- OpenFeign
- REST Template
- Apache Kafka
- Zookeeper
- Spring Actuator
- Keycloak (Authentication & Authorization)
- Docker & Docker Compose
- GitHub Actions (CI/CD)

---

## Architecture

This project follows a **Microservices Architecture** with **Domain Driven Design (DDD)** principles.

### Core Components

- **Configuration Server**
    - Centralized configuration management

- **Discovery Server (Eureka)**
    - Service registration and discovery

- **API Gateway**
    - Single entry point for all services

- **Customer Service**
    - Manage customer data

- **Product Service**
    - Manage product catalog

- **Order Service**
    - Handle order creation and order lines

- **Payment Service**
    - Manage payment processing

- **Notification Service**
    - Send notifications and order confirmations

---

## Communication

The system demonstrates both **synchronous** and **asynchronous** communication.

### Synchronous
- OpenFeign
- REST Template

### Asynchronous
- Apache Kafka

---

## Security

Authentication and authorization are handled using:

- **Keycloak**
- Secured API Gateway
- OAuth2 / JWT based authentication

---

## Observability

Monitoring and tracing are implemented using:

- **Spring Actuator**
- **Zipkin** for distributed tracing

---

## Infrastructure

The project uses **Docker & Docker Compose** to run infrastructure services:

- Kafka
- Zookeeper
- Zipkin
- Keycloak
- Databases
