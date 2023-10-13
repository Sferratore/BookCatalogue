import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/")
public class VisitCounter extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        //getSession gets the Session if it already existed otherwise it creates a new one.
       HttpSession session = request.getSession();
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       if(session.getAttribute("counter") == null){
        session.setAttribute("counter", 1);
       }
       else{
        session.setAttribute("counter", (int) session.getAttribute("counter") + 1);
       }

       out.println("Numero di volte che hai visitato il sito: " + session.getAttribute("counter"));
       
    }

}