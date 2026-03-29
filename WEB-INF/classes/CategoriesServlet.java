import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

// This servlet handles displaying the food categories to the user
public class CategoriesServlet extends HttpServlet {

    // Handle GET requests to show food categories
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws IOException {

        // Set content type and get writer
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // HTML START
        out.println("<html><head><title>Categories</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f4f4f4; text-align:center; }");
        out.println(".box { background:white; padding:20px; margin:50px auto; width:300px; border-radius:10px; box-shadow:0 0 10px gray; }");
        out.println("a { display:block; margin:10px; padding:10px; background:orange; color:white; text-decoration:none; border-radius:5px; }");
        out.println("</style></head><body>");
        
        out.println("<div class='box'>");
        out.println("<h2>Food Categories</h2>");

        // Links to different categories
        out.println("<a href='items?category=pizza'>Pizzas</a>");
        out.println("<a href='items?category=burger'>Burgers</a>");
        out.println("<a href='items?category=wrap'>Wrap & Rolls</a>");
        out.println("<a href='items?category=sides'>Sides</a>");
        out.println("<a href='items?category=dessert'>Desserts</a>");
        out.println("<a href='items?category=drinks'>Cold Drinks</a>");
        out.println("<a href='items?category=coffee'>Coffees</a>");
        out.println("<a href='items?category=shake'>Shakes & Coolers</a>");
        out.println("<a href='items?category=other'>Other Drinks</a>");

        out.println("</div></body></html>");
    }
}