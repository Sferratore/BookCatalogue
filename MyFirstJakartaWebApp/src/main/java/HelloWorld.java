//"HelloWorld" servlet. (Folder "Java" contains servlets)

//Import of standard libraries and jakarta (Jakarta, as per Maven's rules, needs to be defined in pom.xml before using.)
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

//Java annotation to link this servlet to the /HelloWorld call ([fullprojecturl]/HelloWorld to call the servlet).
@WebServlet("/HelloWorld")
//Servlet class 
public class HelloWorld extends HttpServlet {
    //Method activated when the servlet is called with a GET
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException 
    {
        //Defining the html document in response
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>There you go! Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>There you go! Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}