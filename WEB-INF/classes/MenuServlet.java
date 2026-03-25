import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Menu</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f4f4f4; text-align: center; }");
        out.println(".box { background: white; padding: 20px; margin: 50px auto; width: 300px; border-radius: 10px; box-shadow: 0 0 10px gray; }");
        out.println("input { width: 90%; padding: 8px; margin: 8px; }");
        out.println("button { background: green; color: white; padding: 10px; border: none; border-radius: 5px; width: 100%; }");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class='box'>");

        out.println("<h2> Food Menu</h2>");
        out.println("<form action='order' method='post'>");

        out.println("Pizza (₹200)<br>");
        out.println("<input type='number' name='pizza'><br>");

        out.println("Burger (₹150)<br>");
        out.println("<input type='number' name='burger'><br>");

        out.println("Fries (₹120)<br>");
        out.println("<input type='number' name='fries'><br>");

        out.println("Softy (₹50)<br>");
        out.println("<input type='number' name='softy'><br><br>");

        out.println("<button type='submit'>Order Now</button>");

        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}