# Important Info
* The exercises are created and executed on VSCode. All the following info is pertinent to VSCode IDE.
  
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

## RequestInfo
Same important info as "MyFirstJakartaWebApp". This exercise shows the usage of the "request" object created by the infrastructure.

## CalculatorWebApp
Same important info as "MyFirstJakartaWebApp". This exercise implements a simple 4 operations calculator as a web app.

## VisitCounter
Same important info as "MyFirstJakartaWebApp". This exercise implements a simple visits counter.
* You can set a servlet as the first executed code on connection to the webapp.
 1. Remove index.jsp from your project.
 2. Add **@WebServlet("/")** to the servlet you want to start with.
