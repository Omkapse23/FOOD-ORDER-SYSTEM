import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();

        // Get cart from session
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");

        // Get username
        String user = (String) session.getAttribute("user");

        int total = 0;

        out.println("<html><head><title>Order Summary</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f4f4f4; text-align:center; }");
        out.println(".box { background:white; padding:25px; margin:60px auto; width:350px; border-radius:12px; box-shadow:0 0 12px gray; }");
        out.println(".item { margin:8px 0; }");
        out.println(".total { margin-top:15px; font-size:22px; font-weight:bold; color:green; }");
        out.println("a { display:inline-block; margin-top:15px; padding:10px 15px; background:orange; color:white; text-decoration:none; border-radius:5px; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='box'>");
        out.println("<h2>Order Summary</h2>");
        out.println("<p><b>User :</b> " + user + "</p>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty!</p>");
        } else {

            for (String item : cart.keySet()) {

                int qty = cart.get(item);
                int price = 0;
                String name = item;

                switch (item) {

                    //  PIZZA
                    case "classic": price = 49; name = "Classic Pizza"; break;
                    case "paneer": price = 99; name = "Paneer Capsicum Pizza"; break;
                    case "margherita": price = 200; name = "Margherita Pizza"; break;
                    case "farmhouse": price = 250; name = "Farmhouse Pizza"; break;
                    case "veggie": price = 230; name = "Veggie Delight Pizza"; break;
                    case "corn": price = 220; name = "Corn & Cheese Pizza"; break;

                    // BURGER
                    case "vegclassic": price = 120; name = "Veg Classic Burger"; break;
                    case "vegcheese": price = 140; name = "Veg Cheese Burger"; break;
                    case "paneerburger": price = 180; name = "Paneer Burger"; break;
                    case "crispyveg": price = 150; name = "Crispy Veg Burger"; break;
                    case "doublecheese": price = 220; name = "Double Cheese Burger"; break;
                    case "cheesepaneer": price = 250; name = "Double Cheese Paneer Burger"; break;

                    // WRAPS
                    case "paneerwrap": price = 180; name = "Paneer Tikka Wrap"; break;
                    case "vegwrap": price = 150; name = "Veg Cheese Wrap"; break;
                    case "aloowrap": price = 120; name = "Aloo Tikki Wrap"; break;
                    case "vegmayo": price = 140; name = "Veg Mayo Roll"; break;
                    case "masalawrap": price = 160; name = "Masala Roll"; break;
                    case "eggroll": price = 100; name = "Egg Roll"; break;

                    //  SIDES
                    case "frenchfries": price = 80; name = "French Fries"; break;
                    case "vegpuff": price = 60; name = "Veg Pizza Puff"; break;
                    case "corncup": price = 70; name = "Corn Cup"; break;
                    case "vegcutlet": price = 90; name = "Veg Cutlet"; break;
                    case "garlicbread": price = 110; name = "Garlic Bread"; break;
                    case "garlicbreadcheese": price = 140; name = "Garlic Bread with Cheese"; break;

                    // DESSERTS
                    case "brownie": price = 90; name = "Chocolate Brownie"; break;
                    case "lavacake": price = 120; name = "Choco Lava Cake"; break;
                    case "vanillaicecream": price = 50; name = "Vanilla Ice Cream"; break;
                    case "chocolateicecream": price = 60; name = "Chocolate Ice Cream"; break;
                    case "strawberryicecream": price = 55; name = "Strawberry Ice Cream"; break;
                    case "gulabjamun": price = 40; name = "Gulab Jamun"; break;

                    // DRINKS
                    case "cocacola": price = 40; name = "Coca Cola"; break;
                    case "pepsi": price = 40; name = "Pepsi"; break;
                    case "sprite": price = 40; name = "Sprite"; break;
                    case "fanta": price = 40; name = "Fanta"; break;
                    case "thumsup": price = 40; name = "Thums Up"; break;
                    case "mountaindew": price = 40; name = "Mountain Dew"; break;

                    // COFFEE
                    case "espresso": price = 100; name = "Espresso"; break;
                    case "cappuccino": price = 120; name = "Cappuccino"; break;
                    case "latte": price = 150; name = "Latte"; break;
                    case "americano": price = 110; name = "Americano"; break;
                    case "mocha": price = 130; name = "Mocha"; break;
                    case "coldcoffee": price = 90; name = "Cold Coffee"; break;

                    //  SHAKES
                    case "chocolateshake": price = 120; name = "Chocolate Shake"; break;
                    case "vanillashake": price = 100; name = "Vanilla Shake"; break;
                    case "strawberryshake": price = 110; name = "Strawberry Shake"; break;
                    case "mangoshake": price = 130; name = "Mango Shake"; break;
                    case "oreoshake": price = 150; name = "Oreo Shake"; break;
                    case "coldcoffeeshake": price = 140; name = "Cold Coffee Shake"; break;

                    //  OTHER DRINKS
                    case "lemonade": price = 60; name = "Lemonade"; break;
                    case "icedtea": price = 70; name = "Iced Tea"; break;
                    case "virginmojito": price = 80; name = "Virgin Mojito"; break;
                    case "coldcoffeeother": price = 90; name = "Cold Coffee"; break;
                    case "fruitpunch": price = 100; name = "Fruit Punch"; break;
                    case "mintcooler": price = 70; name = "Mint Cooler"; break;
                }

                int itemTotal = price * qty;
                total += itemTotal;

                out.println("<div class='item'>" + name + " x " + qty + " = ₹" + itemTotal + "</div>");
            }

            out.println("<div class='total'>Total: ₹" + total + "</div>");
        }

        out.println("<a href='categories'> Order Again</a>");
        out.println("</div></body></html>");

        // Clear cart after order
        session.removeAttribute("cart");
    }
}