import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

// This servlet handles user login and session management
public class LoginServlet extends HttpServlet {

    // Handle POST requests for user login
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
                throws IOException {

                    // Get the username from the form
                    String name = req.getParameter("username");

                    // Create a session and store the username
                    HttpSession session = req.getSession();
                    session.setAttribute("user", name);

                    // Redirect to categories page after login
                    res.sendRedirect("categories");
                }
}