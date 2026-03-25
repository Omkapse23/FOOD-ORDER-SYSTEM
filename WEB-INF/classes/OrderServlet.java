import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // 🔹 Get values
        String pizzaStr = req.getParameter("pizza");
        String burgerStr = req.getParameter("burger");
        String friesStr = req.getParameter("fries");
        String softyStr = req.getParameter("softy");

        // 🔹 Convert safely
        int pizza = (pizzaStr != null && !pizzaStr.isEmpty()) ? Integer.parseInt(pizzaStr) : 0;
        int burger = (burgerStr != null && !burgerStr.isEmpty()) ? Integer.parseInt(burgerStr) : 0;
        int fries = (friesStr != null && !friesStr.isEmpty()) ? Integer.parseInt(friesStr) : 0;
        int softy = (softyStr != null && !softyStr.isEmpty()) ? Integer.parseInt(softyStr) : 0;

        // 🔹 Calculate total
        int total = (pizza * 200) + (burger * 150) + (fries * 120) + (softy * 50);

        // 🔹 Session user
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        // 🔹 HTML START
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Order Summary</title>");

        // CSS
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f4f4f4; text-align: center; }");
        out.println(".box { background: white; padding: 20px; margin: 50px auto; width: 300px; border-radius: 10px; box-shadow: 0 0 10px gray; }");
        out.println(".total { color: green; font-size: 20px; font-weight: bold; }");
        out.println("a { text-decoration: none; color: blue; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h2>Order Summary</h2>");
        out.println("<p><b>Customer:</b> " + user + "</p>");

        if (pizza > 0) out.println("Pizza: " + pizza + "<br>");
        if (burger > 0) out.println("Burger: " + burger + "<br>");
        if (fries > 0) out.println("Fries: " + fries + "<br>");
        if (softy > 0) out.println("Softy: " + softy + "<br>");

        out.println("<br><div class='total'>Total: ₹" + total + "</div>");

        out.println("<br><a href='menu'>Order Again</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}