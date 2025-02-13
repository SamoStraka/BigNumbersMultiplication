## TASK

### Calculate multiplication
=======================
Program which computes the multiplication of two large numbers (integers) entered as command
line arguments.

### How to run the program

1. Clone the repository

## Install
1. Go to the root directory of the project
2. Move to api - run the following command in the terminal ```cd api```
3. Build the API ```mvn clean install```
4. Move to target - run the following command in the terminal ```cd ../application/target```
5. Build the application ```mvn clean install```

## RUN - after installing

### Run from the terminal

- Run following - when in target folder ```java -jar multiplication-application-1.0.0-SNAPSHOT.jar --alg1 112 2```


### Run from the IDE
- check using swagger
1. Run the `@LargeNumberMultiplication.java` file
2. Test it using swagger - default - `http://localhost:8080/swagger-ui/index.html`