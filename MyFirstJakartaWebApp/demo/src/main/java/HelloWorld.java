import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
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