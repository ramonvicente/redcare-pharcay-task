# Redcare Pharmacy Pratical Task

## SetUp and Run
In order to run the application with gradle: 

- run ```./gradlew build``` to build the application
- then run ```docker build -t redcare-pharmacy-task:latest``` to run the docker image.
- and ```docker run -p 8080:8080 redcare-pharmacy-task:latest``` to run the application

To run the tests: 
- ```./gradlew test```

## Endpoints
- For information about the endpoint access the swagger documentation: http://localhost:8080/swagger-ui/index.html

### get most popular github repositories 
```
curl --location 'http://localhost:8080/repositories/github/most-popular?sinceDate=2019-01-10&limit=3&language=java' \
--data ''
```
Params:
- ```sinceDate``` is the date onwards that sould be return
- ```limit``` is the number of repositories to be return (max is 100). It is an optional field
- ```language``` is the  language of the code in the repositories. It is an optional field

## Assumptions and Decisions
- I assumed that the ```limit``` and ```language``` are optional possibilities for the application.
- I don't know the level of testing that was required but I focused in the basics scenarios for now.
- I added comment in the code, I thought would be better than add then here.

Thank you for the challenge :)