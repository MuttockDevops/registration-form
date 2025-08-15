# Aeroparker Registration (Spring Boot · Java 17)

Customer registration form at `http://localhost:8080/registration` with server-side validation and a success page.

## Run (H2 – zero setup)
```bash
./gradlew bootRun
# App: http://localhost:8080/registration
# H2 console: http://localhost:8080/h2-console  (JDBC: jdbc:h2:mem:aeroparker, user: sa, pass: blank)
Run with MySQL (local)
./gradlew bootRun --args='--spring.profiles.active=mysql'


src/main/resources/application-mysql.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/aeroparker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=aeroparker
spring.datasource.password=aeroparker_pw
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Run with Docker (app + MySQL)
docker compose up --build
# App:   http://localhost:8080/registration
# MySQL: 127.0.0.1:3307 (user: aeroparker, pass: aeroparker_pw)


(Optional) load sample data into the container DB:

docker compose exec -T db sh -c 'exec mysql -uaeroparker -paeroparker_pw aeroparker' < db/aeroparker.sql

Database dump
# imports DB + table + sample rows
mysql -u root -p < db/aeroparker.sql

Endpoints

GET /registration – form

POST /registration – submit

(Optional) GET /api/email-available?email=... – inline email check
