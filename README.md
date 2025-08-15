# Aeroparker Registration

Spring Boot (Java 17). H2 by default; MySQL profile provided.

## Run (H2)
mvn spring-boot:run
# http://localhost:8080/registration
# H2 console: http://localhost:8080/h2-console  (JDBC: jdbc:h2:mem:aeroparker, user: sa)

## Run with MySQL
mvn spring-boot:run -Dspring-boot.run.profiles=mysql

### application-mysql.properties
spring.datasource.url=jdbc:mysql://localhost:3306/aeroparker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=aeroparker
spring.datasource.password=aeroparker_pw
spring.jpa.hibernate.ddl-auto=update

## Database dump (MySQL 8)
Import everything with one command:
mysql -u root -p < db/aeroparker.sql
