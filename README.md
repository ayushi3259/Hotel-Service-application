# **Hotel Service with Rating and API Gateway Microservices**

This repository contains three Spring Boot microservices: Hotel Service, Rating Service, and API Gateway, along with a Service Registry. These services manage hotel information, ratings, and API routing, forming a complete microservices architecture.

## Features

- **Hotel Service**: CRUD operations for hotel information.
- **Rating Service**: CRUD operations for ratings associated with hotels.
- **API Gateway**: Routes API requests to the appropriate services using Eureka for service discovery.
- **Service Registry**: Service discovery with Eureka server.
- **Resilience**: Fault tolerance and rate limiting using Resilience4j.

## Technologies Used

- Java
- Spring Boot
- Spring Cloud Gateway
- Spring Data JPA
- Netflix Eureka
- MySQL
- Resilience4j

## Setup

### Prerequisites

- JDK 11 or higher
- Maven
- MySQL database

