import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession();

        // Get cart from session
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        // Loop through all parameters
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String item = params.nextElement();
            int qty = getValue(req, item);

            if (qty > 0) {
                cart.put(item, cart.getOrDefault(item, 0) + qty);
            }
        }

        // Save back to session
        session.setAttribute("cart", cart);

        // Redirect to cart page
        res.sendRedirect("cart");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");

        out.println("<html><head><title>Cart</title>");

        // CSS ADDED (only styling)
        out.println("<style>");
        out.println("body { font-family: Arial; background:#f4f4f4; text-align:center; }");
        out.println(".container { width:60%; margin:auto; background:white; padding:20px; border-radius:10px; box-shadow:0 0 10px gray; }");
        out.println("h2 { color:#333; }");
        out.println(".item { font-size:18px; margin:10px 0; padding:10px; border-bottom:1px solid #ddd; }");
        out.println(".empty { color:red; font-size:18px; }");
        out.println(".btn { display:inline-block; margin:15px; padding:10px 20px; background:#28a745; color:white; border:none; border-radius:5px; cursor:pointer; }");
        out.println(".btn:hover { background:#218838; }");
        out.println(".link { display:inline-block; margin-top:15px; text-decoration:none; color:#007bff; }");
        out.println(".link:hover { text-decoration:underline; }");
        out.println("</style>");

        out.println("</head><body>");
        out.println("<div class='container'>");

        out.println("<h2>Your Cart</h2>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p class='empty'>Cart is empty</p>");
        } else {
            for (String item : cart.keySet()) {
                out.println("<div class='item'>" + item + " : " + cart.get(item) + "</div>");
            }

            out.println("<form action='order' method='post'>");
            out.println("<button class='btn' type='submit'>Place Order</button>");
            out.println("</form>");
        }

        out.println("<a href='categories' class='link'>⬅ Continue Shopping</a>");

        out.println("</div>");
        out.println("</body></html>");
    }

    private int getValue(HttpServletRequest req, String name) {
        String val = req.getParameter(name);
        return (val != null && !val.isEmpty()) ? Integer.parseInt(val) : 0;
    }
}