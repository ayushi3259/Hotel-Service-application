Hotel Service (Microservices)
This repository contains three Spring Boot microservices: Hotel Service, Rating Service, and API Gateway, along with a Service Registry. These services manage hotel information, ratings, and API routing, forming a complete microservices architecture.

Features
Hotel Service: CRUD operations for hotel information.
Rating Service: CRUD operations for ratings associated with hotels.
API Gateway: Routes API requests to the appropriate services using Eureka for service discovery.
Service Registry: Service discovery with Eureka server.
Resilience: Fault tolerance and rate limiting using Resilience4j.
Technologies Used
Java
Spring Boot
Spring Cloud Gateway
Spring Data JPA
Netflix Eureka
MySQL
Resilience4j
Setup
Prerequisites
JDK 11 or higher
Maven
MySQL database
Steps
Clone the repository:

sh
Copy code
git clone https://github.com/yourusername/microservices-project.git
cd microservices-project
Configure the MySQL databases for each service in their respective application.yml files.

Build the projects:

sh
Copy code
mvn clean install
Run the services:

sh
Copy code
cd ServiceRegistry
mvn spring-boot:run
sh
Copy code
cd HotelService
mvn spring-boot:run
sh
Copy code
cd RatingService
mvn spring-boot:run
sh
Copy code
cd ApiGateway
mvn spring-boot:run
Usage
The services expose RESTful endpoints for managing hotels and ratings. The API Gateway routes requests to the appropriate service based on the URL path.
