import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Calculate")
public class CalculatorController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        String operation = request.getParameter("operation");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(operation.equals("sum")){
            out.println("<p>" + (num1 + num2) + "</p>");
        }
        else if(operation.equals("subt")){
            out.println("<p>" + (num1 - num2) + "</p>");
        }
        else if(operation.equals("mult")){
            out.println("<p>" + (num1*num2) + "</p>");
        }
        else if(operation.equals("split")){
            out.println("<p>" + (num1/num2) + "</p>");
        }
        else{
            out.println("<p> WRONG DATA >:(</p>");
        }
    }

}
