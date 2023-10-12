# JavaTraining
Following will be added important information on the exercises contained in the repository.

## MyFirstJakartaWebApp
The important steps in creating your first Jakarta Web App are the following (not in order).
* Add Jakarta dependency on pom.xml.
* Add "Java" (Or other name) folder to add your backend code. There you can create servlets importing all the necessary jakarta libs.
* Use Maven -> Plugins -> War -> Exploded to build  inside "Target" folder a compressed version of your project
* Go to Servers
  * Use the Community Servers Connector to create an Apache Tomcat Server
* Right click on your compressed project folder under "Target" and follow "Run on server" to deploy your app on the Tomcat server created.
* To execute your deployed project, right click on your Tomcat Server -> Show Actions -> Show in browser -> Select the URL of localhost + the name of your project.
