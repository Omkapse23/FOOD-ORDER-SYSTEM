import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

// This servlet handles user login and session management
public class LoginServlet extends HttpServlet {

    // Handle POST requests for user login
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
                throws IOException {

                    PrintWriter out = res.getWriter();

                    // Get the username & Phone number from the form
                    String name = req.getParameter("username");
                    String  phone = req.getParameter("phone");

                    // name validation
                    if(name == null || name.trim().isEmpty()) {
                        out.println("<h3>Name cannot be empty</h3>");
                        return;
                    }

                    if(phone == null || phone.trim().isEmpty()) {
                        out.println("<h3>Phone number cannot be empty</h3>");
                        return;
                    }

                    // Create a session and store the username
                    HttpSession session = req.getSession();
                    session.setAttribute("user", name);

                    // Redirect to categories page after login
                    res.sendRedirect("categories");
                }
}