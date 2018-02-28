# invitation-microservice
Example of microservice.
This project include:
1. Client app
2. Microservice

###Client App
The main goal of this project send only one call to service.

###Services
According to the Microservices architecture I divide whole application into separate serveries.
Each service are salable and independently deploy-able

The **main-view-service** responsible for performing request and call another service

The **submitting-email-service** responsible for sending email.

The **api-gateway-server** is front door of the system. This service use Netflix Zuul

The **eureka-naming-server** is the Service Discovery


### run eureka-naming-server
  * go inside to the eureka-naming-server project folder
  * then run ``` mvn spring-boot:run ```
  
### run api-gateway-server
  * go inside to the api-gateway-server project folder
  * then run ``` mvn spring-boot:run ```
  
### run main-view-service
  * go inside to the auth-service project folder
  * then run ``` mvn spring-boot:run ```
  
### run submitting-email-service
  * go inside to the product-service project folder
  * then run ``` mvn spring-boot:run ```

### run client app
  * go inside to the invitation-client project folder
  * then run ``` yarn install ```
  * then run ``` npm start ```