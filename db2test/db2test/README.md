### Installing db2 community edition Docker image
* Create docker-compose file using below content
```
version: '3'
services:
  database:
    image: ibmcom/db2
    privileged: true
    restart: always
    ports:
      - 50000:50000
    environment: 
      - LICENSE=accept
      - DB2INSTANCE=db2inst1
      - DB2INST1_PASSWORD=admin
      - DBNAME=testdb           
      - SAMPLEDB=true
    volumes:
      - db-data-testdb:/var/lib/db2/data/testdb
    
volumes:
  db-data-testdb:
```
* alternatively found the docker-compose file in db folder .
* run docker-compose up
* It will take while to create database called "testdb"
#### Spring boot configuration to connect 
application.properties
```
spring.datasource.driver-class-name=com.ibm.db2.jcc.DB2Driver
spring.datasource.username=db2inst1
spring.datasource.password=admin
spring.datasource.url=jdbc:db2://localhost:50000/testdb
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto =create
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.DB2Dialect
```
#### Run the application
mvnw clean spring-boot:run
