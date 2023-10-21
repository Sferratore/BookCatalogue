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
