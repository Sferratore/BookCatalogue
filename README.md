# JavaTraining
JavaTraining is a repository in which different Java exercises are loaded, divided by topics. These exercises are developed and commented so that they result consultable and useful for learning.

# Fundamentals
The "Fundamentals" folder contains exercises which revolve around topics of OOP and basic Java programming.

**_HelloWorld_** : Write a program that prints "Hello World!" to the console.

**_CharSubstitution_** : Write a program that replaces "ss" with "s" and "i" with "ii" in "Mississipi".

**_RandomPrice_** : Print a random price between 10$ and 19.99$. Use the "Random" class.

**_VideogameExercise_** : VideogameExercise is an exercise which simulates the interaction of a user and an admin with a videogame system. **TO COMPLETE**



# Java Spring
The "Spring" folder contains exercises which revolve around the Java Spring Boot framework. The starting point of project directory tree is generated using: https://start.spring.io/ .

**_HelloWorld_** : Write a program using Spring which returns "Hello, world!" when a GET call is done on "/hello". Generate the project with Spring Initializr adding as dependencies "Spring Boot DevTools" and "Spring Web". To see the result of the program, after executing it with _mvn spring-boot:run_, call on your browser for _localhost:8081/hello_.





# Important Info
* During the course, some projects have been requested to be created using Eclipse and others using Visual Studio Code. The repo is currently adapting to transfer every project on Eclipse.

* Following, important info you should know about working with JDBC projects (Eclipse IDE).
  * Guide for adding connector JAR to your Eclipse project: https://stackoverflow.com/questions/74880235/how-to-deploy-jdbc-jar-file-in-my-eclipse

* Following, important info you should know about working with Jakarta, Servlets, JSPs (VSCode IDE).
  * You need to add Jakarta dependency on pom.xml.
  * (NOT MANDATORY) Add "Java" (Or other name) folder to add your backend code. There you can create servlets importing all the necessary jakarta libs.
  * Use Maven -> Plugins -> War -> Exploded to build  inside "Target" folder a compressed version of your project
  * Go to Servers and use the Community Servers Connector to create an Apache Tomcat Server
  * Right click on your compressed project folder under "Target" and follow "Run on server" to deploy your app on the Tomcat server created.
  * To execute your deployed project, right click on your Tomcat Server -> Show Actions -> Show in browser -> Select the URL of localhost + the name of your project.

## Common things you should probably know about
* You can set a servlet as the first executed code on connection to the webapp.
 1. Remove index.jsp from your project.
 2. Add **@WebServlet("/")** to the servlet you want to start with.
