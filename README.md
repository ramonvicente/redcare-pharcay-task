# Redcare Pharmacy Pratical Task

## SetUp and Run
In order to run the application with gradle: 

- run application:
```./gradlew bootRun```
- run tests:
```./gradlew test```

## Endpoints
- For information about the endpoint access the swagger documentation: http://localhost:8080/swagger-ui/index.html

### get most popular github repositories 
```
curl --location 'http://localhost:8080/repositories/github/most-popular?sinceDate=2019-01-10&language=java' \
--data ''
```

## Assumptions and Decisions