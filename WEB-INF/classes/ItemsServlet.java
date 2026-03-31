import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

// This servlet handles displaying the menu items based on the selected category
public class ItemsServlet extends HttpServlet {

    // Handle GET requests to show menu items for a specific category
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        // Get the category from query parameter
        String category = req.getParameter("category");

        // Set content type and get writer
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Safety check
        if (category == null || category.isEmpty()) {
            out.println("<h2>No category selected!</h2>");
            return;
        }

        // HTML START
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Food Menu</title>");

        // Simple CSS
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f2f2f2; text-align: center; }");
        out.println(".box { background: white; padding: 20px; margin: 50px auto; width: 300px; border-radius: 8px; box-shadow: 0 0 5px gray; }");
        out.println("h2 { margin-bottom: 15px; }");
        out.println(".item { margin: 10px 0; }");
        out.println("input { width: 50px; padding: 5px; margin-left: 10px; }");
        out.println("button { width: 100%; padding: 10px; background: orange; color: white; border: none; border-radius: 5px; margin-top: 15px; cursor: pointer; }");
        out.println("button:hover { background: darkorange; }");
        out.println("a { display:block; margin-top:10px; text-decoration:none; }");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class='box'>");

        out.println("<h2>" + category.toUpperCase() + " Menu</h2>");
        out.println("<form action='order' method='post'>");

        // PIZZA
        if ("pizza".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Classic (₹49) <input type='number' name='classic' min='0' max='10'></div>");
            out.println("<div class='item'>Paneer Capsicum (₹99) <input type='number' name='paneer'min='0' max='10'></div>");
            out.println("<div class='item'>Margherita (₹200) <input type='number' name='margherita'min='0' max='10'></div>");
            out.println("<div class='item'>Farmhouse (₹250) <input type='number' name='farmhouse'min='0' max='10'></div>");
            out.println("<div class='item'>Veggie Delight (₹230) <input type='number' name='veggie'min='0' max='10'></div>");
            out.println("<div class='item'>Corn & Cheese (₹220) <input type='number' name='cornmin='0' max='10''></div>");
        }

        // BURGER
        if ("burger".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Veg Classic (₹120) <input type='number' name='vegclassic' min='0' max='10'></div>");
            out.println("<div class='item'>Veg Cheese Burger (₹140) <input type='number' name='vegcheese' min='0' max='10'></div>");
            out.println("<div class='item'>Paneer Burger (₹180) <input type='number' name='paneerburger' min='0' max='10'></div>");
            out.println("<div class='item'>Crispy Veg Burger (₹150) <input type='number' name='crispyveg' min='0' max='10'></div>");
            out.println("<div class='item'>Double Cheese Burger (₹220) <input type='number' name='doublecheese' min='0' max='10'></div>");
            out.println("<div class='item'>Double Cheese Paneer Burger (₹250) <input type='number' name='cheesepaneer' min='0' max='10'></div>");
        }

        // WRAPS
        if ("wrap".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Paneer Tikka Wrap (₹180) <input type='number' name='paneerwrap' min='0' max='10'></div>");
            out.println("<div class='item'>Veg Cheese Wrap (₹150) <input type='number' name='vegwrap' min='0' max='10'></div>");
            out.println("<div class='item'>Aloo Tikki Wrap (₹120) <input type='number' name='aloowrap' min='0' max='10'></div>");
            out.println("<div class='item'>Veg Mayo Roll (₹140) <input type='number' name='vegmayo' min='0' max='10'></div>");
            out.println("<div class='item'>Masala Roll (₹160) <input type='number' name='masalawrap' min='0' max='10'></div>");
            out.println("<div class='item'>Egg Roll (₹100) <input type='number' name='eggroll' min='0' max='10'></div>");
        }

        //SIDES
        if("sides".equalsIgnoreCase(category)) {
            out.println("<div class='item'>French Fries (Small) (₹80) <input type='number' name='frenchfries' min='0' max='10'></div>");
            out.println("<div class='item'>Veg Pizza Puff (₹60) <input type='number' name='vegpuff' min='0' max='10'></div>");
            out.println("<div class='item'>Corn Cup (₹70) <input type='number' name='corncup' min='0' max='10'></div>");
            out.println("<div class='item'>Veg Cutlet (₹90) <input type='number' name='vegcutlet' min='0' max='10'></div>");
            out.println("<div class='item'>Garlic Bread (2 pcs) (₹110) <input type='number' name='garlicbread' min='0' max='10'></div>");
            out.println("<div class='item'>Garlic Bread with Cheese (₹140) <input type='number' name='garlicbreadcheese' min='0' max='10'></div>");
        }

        //DESSERTS
        if("dessert".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Chocolate Brownie (₹90) <input type='number' name='brownie' min='0' max='10'></div>");
            out.println("<div class='item'>Choco Lava Cake (₹120) <input type='number' name='lavacake' min='0' max='10'></div>");
            out.println("<div class='item'>Vanilla Ice Cream (₹50) <input type='number' name='vanillaicecream' min='0' max='10'></div>");
            out.println("<div class='item'>Chocolate Ice Cream (₹60) <input type='number' name='chocolateicecream' min='0' max='10'></div>");
            out.println("<div class='item'>Strawberry Ice Cream (₹55) <input type='number' name='strawberryicecream' min='0' max='10'></div>");
            out.println("<div class='item'>Gulab Jamun (₹40) <input type='number' name='gulabjamun' min='0' max='10'></div>");
        }

        //COLD DRINKS
        if("drinks".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Coca Cola (₹40) <input type='number' name='cocacola' min='0' max='10'></div>");
            out.println("<div class='item'>Pepsi (₹40) <input type='number' name='pepsi' min='0' max='10'></div>");
            out.println("<div class='item'>Sprite (₹40) <input type='number' name='sprite' min='0' max='10'></div>");
            out.println("<div class='item'>Fanta (₹40) <input type='number' name='fanta' min='0' max='10'></div>");
            out.println("<div class='item'>Thums Up (₹40) <input type='number' name='thumsup' min='0' max='10'></div>");
            out.println("<div class='item'>Mountain Dew (₹40) <input type='number' name='mountaindew' min='0' max='10'></div>");
        }

        //Coffees
        if("coffee".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Espresso (₹100) <input type='number' name='espresso' min='0' max='10'></div>");
            out.println("<div class='item'>Cappuccino (₹120) <input type='number' name='cappuccino' min='0' max='10'></div>");
            out.println("<div class='item'>Latte (₹150) <input type='number' name='latte' min='0' max='10'></div>");
            out.println("<div class='item'>Americano (₹110) <input type='number' name='americano' min='0' max='10'></div>");
            out.println("<div class='item'>Mocha (₹130) <input type='number' name='mocha' min='0' max='10'></div>");
            out.println("<div class='item'>Cold Coffee (₹90) <input type='number' name='coldcoffee' min='0' max='10'></div>");
        }

        //Shakes & Coolers
        if("shake".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Chocolate Shake (₹120) <input type='number' name='chocolateshake' min='0' max='10'></div>");
            out.println("<div class='item'>Vanilla Shake (₹100) <input type='number' name='vanillashake' min='0' max='10'></div>");
            out.println("<div class='item'>Strawberry Shake (₹110) <input type='number' name='strawberryshake' min='0' max='10'></div>");
            out.println("<div class='item'>Mango Shake (₹130) <input type='number' name='mangoshake' min='0' max='10'></div>");
            out.println("<div class='item'>Oreo Shake (₹150) <input type='number' name='oreoshake' min='0' max='10'></div>");
            out.println("<div class='item'>Cold Coffee Shake (₹140) <input type='number' name='coldcoffeeshake' min='0' max='10'></div>");
        }

        //OTHER DRINKS
        if("other".equalsIgnoreCase(category)) {
            out.println("<div class='item'>Lemonade (₹60) <input type='number' name='lemonade' min='0' max='10'></div>");
            out.println("<div class='item'>Iced Tea (₹70) <input type='number' name='icedtea' min='0' max='10'></div>");
            out.println("<div class='item'>Virgin Mojito (₹80) <input type='number' name='virginmojito' min='0' max='10'></div>");
            out.println("<div class='item'>Cold Coffee (₹90) <input type='number' name='coldcoffeeother' min='0' max='10'></div>");
            out.println("<div class='item'>Fruit Punch (₹100) <input type='number' name='fruitpunch' min='0' max='10'></div>");
            out.println("<div class='item'>Mint Cooler (₹70) <input type='number' name='mintcooler' min='0' max='10'></div>");
        }

        out.println("<button type='submit'>Order Now</button>");
        out.println("</form>");

        // Back button
        out.println("<a href='categories'>⬅ Back</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}