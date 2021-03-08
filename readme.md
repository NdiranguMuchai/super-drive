# Super Drive

This is an application for storing user `files` and website `credentials` securely.

* The project uses [My Batis](https://mybatis.org/mybatis-3/) as its ORM manager & `Spring Security` for authentication and authorization.
* [Selenium](https://www.selenium.dev/) has been implemented in the unit tests to mimic user actions.
* No database configuration is required as the application uses an in-memory `H2` database.
### Prerequisites
* Java 15
* Your preferred IDE

### Running Super Drive locally
Super drive is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

```
git clone https://github.com/NdiranguMuchai/super-dive.git
cd super-drive
./mvnw package
java -jar target/*.jar
```
Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

You can then access the login page here: http://localhost:8080

New users will be required to signup first: http://localhost:8080/signup

After successful login, you will be redirected to the home page

<img width="1042" alt="home" src="https://user-images.githubusercontent.com/47880944/110317407-2cdcb200-801d-11eb-8582-600f1c9ce2b5.png">

#### Files
* As seen above, you can upload any file type you desire using the upload link.
* The files can then be downloaded using the view button or deleted using the delete button.

#### Credentials
* You can store credentials to other website accounts here.

<img width="1042" alt="credential" src="https://user-images.githubusercontent.com/47880944/110318114-23a01500-801e-11eb-8f5a-0d501d75c68a.png">

* Upon saving, the password will be displayed as an encrypted value.

<img width="1042" alt="credential-section" src="https://user-images.githubusercontent.com/47880944/110318432-885b6f80-801e-11eb-8324-879d9b1c58e4.png">

* For credentials with the same password, a different encrypted value will be displayed each time.

<img width="1042" alt="new-credential" src="https://user-images.githubusercontent.com/47880944/110318937-38c97380-801f-11eb-960c-81ed5c04e16d.png">

<img width="1042" alt="credential-list" src="https://user-images.githubusercontent.com/47880944/110319017-57c80580-801f-11eb-927c-2572cd701ef2.png">

* The credentials can also be updated and deleted using the edit and delete buttons.

#### Notes
* The application can also be used to store notes.

<img width="1042" alt="notes" src="https://user-images.githubusercontent.com/47880944/110319264-b1c8cb00-801f-11eb-8372-36d2c91d4e42.png">

