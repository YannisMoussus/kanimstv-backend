# [KanimsTv Application Backend]

### **The idea :**

KanimsTV API

# [Source code] Some explanations

This project is realized in :coffee:[Java](https://docs.oracle.com/en/java/) with [Springboot framework](https://spring.io/projects/spring-boot).

This project has been generated with [Spring initializr](https://start.spring.io/) and use [Maven](https://maven.apache.org/) to manage its external dependencies.

## Source code structuration

TODO

# [Local development] Launch the application on localhost

- Install Java with **11.x.x minimum version**
- Install Maven with **3.6.x minimum version**

:wrench: Easily install these tools with [**SDKMAN**](https://sdkman.io/install). For Windows, [**SDKMAN_ON_WINDOWS**](https://medium.com/@gayanper/sdkman-on-windows-661976238042).

Install Java :
```
foo@bar:~$ sdk install java 11.0.5.hs-adpt
```
Install Maven :
```
foo@bar:~$ sdk install maven 3.6.3
```
Check your installation : 
```console
foo@bar:~$ java -version
foo@bar:~$ mvn -v
```

## Steps to follow

1. Clone the project (manually or with the git extension for Visual Studio Code)

2. Open it with **Visual Studio Code**

    :thumbsup: [Visual Studio Code](https://code.visualstudio.com/) is a Free IDE, built on open source.

3. Get useful **extensions** on **VsCode**:

    - Lombok Annotations Support for VS Code
    - Spring Boot Dashboard
    - Spring Boot Extension Pack
    - Spring Boot Tools
    - Spring Initializr Java Support


4. Create the **Postgres** container with **custom Database**
    
    ```
    docker build -t postgres-custom .

    docker-compose -f docker-compose.yml up

    docker-compose -f docker-compose.yml down

    ```


5.  Reminder Docker Commands
    
    Interactive Mod :
    ```
    docker exec -it database_db_1 bash
    ```
    Print list of images and containers :
    ```
    docker container ps --all
    docker images
    ```

6. Reminder SQL Commands

    ```
    show databases;
    use NAMEDATABASE;
    show tables;
    show columns from NAMETABLE;
    select * from NAMETABLE;
    ```

# [Local development] Swagger documentation

Swagger documentation available at : http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config