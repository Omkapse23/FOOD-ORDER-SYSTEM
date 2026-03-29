import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

// This servlet handles processing the order and displaying the order summary
public class OrderServlet extends HttpServlet {

    // Handle POST requests to process the order and show summary
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        // Set content type and get writer
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Get all values
        int classic = getValue(req, "classic");
        int paneer = getValue(req, "paneer");
        int margherita = getValue(req, "margherita");
        int farmhouse = getValue(req, "farmhouse");
        int veggie = getValue(req, "veggie");
        int corn = getValue(req, "corn");

        int vegclassic = getValue(req, "vegclassic");
        int vegcheese = getValue(req, "vegcheese");
        int paneerburger = getValue(req, "paneerburger");
        int crispyveg = getValue(req, "crispyveg");
        int doublecheese = getValue(req, "doublecheese");
        int cheesepaneer = getValue(req, "cheesepaneer");

        int paneerwrap = getValue(req, "paneerwrap");
        int vegwrap = getValue(req, "vegwrap");
        int aloowrap = getValue(req, "aloowrap");
        int vegmayo = getValue(req, "vegmayo");
        int masalawrap = getValue(req, "masalawrap");
        int eggroll = getValue(req, "eggroll");

        int frenchfries = getValue(req, "frenchfries");
        int vegpuff = getValue(req, "vegpuff");
        int corncup = getValue(req, "corncup");
        int vegcutlet = getValue(req, "vegcutlet");
        int garlicbread = getValue(req, "garlicbread");
        int garlicbreadcheese = getValue(req, "garlicbreadcheese");

        int brownie = getValue(req, "brownie");
        int lavacake = getValue(req, "lavacake");
        int vanilla = getValue(req, "vanillaicecream");
        int chocolate = getValue(req, "chocolateicecream");
        int strawberry = getValue(req, "strawberryicecream");
        int gulab = getValue(req, "gulabjamun");

        int cocacola = getValue(req, "cocacola");
        int pepsi = getValue(req, "pepsi");
        int sprite = getValue(req, "sprite");
        int fanta = getValue(req, "fanta");
        int thumsup = getValue(req, "thumsup");
        int dew = getValue(req, "mountaindew");

        int espresso = getValue(req, "espresso");
        int cappuccino = getValue(req, "cappuccino");
        int latte = getValue(req, "latte");
        int americano = getValue(req, "americano");
        int mocha = getValue(req, "mocha");
        int coldcoffee = getValue(req, "coldcoffee");

        int chocoshake = getValue(req, "chocolateshake");
        int vanillashake = getValue(req, "vanillashake");
        int strawberryshake = getValue(req, "strawberryshake");
        int mangoshake = getValue(req, "mangoshake");
        int oreoshake = getValue(req, "oreoshake");
        int coldcoffeeshake = getValue(req, "coldcoffeeshake");

        int lemonade = getValue(req, "lemonade");
        int icedtea = getValue(req, "icedtea");
        int mojito = getValue(req, "virginmojito");
        int coldcoffeeother = getValue(req, "coldcoffeeother");
        int fruitpunch = getValue(req, "fruitpunch");
        int mintcooler = getValue(req, "mintcooler");

        //  Total calculation
        int total =
                (classic * 49) + (paneer * 99) + (margherita * 200) + (farmhouse * 250) + (veggie * 230) + (corn * 220) +
                (vegclassic * 120) + (vegcheese * 140) + (paneerburger * 180) + (crispyveg * 150) + (doublecheese * 220) + (cheesepaneer * 250) +
                (paneerwrap * 180) + (vegwrap * 150) + (aloowrap * 120) + (vegmayo * 140) + (masalawrap * 160) + (eggroll * 100) +
                (frenchfries * 80) + (vegpuff * 60) + (corncup * 70) + (vegcutlet * 90) + (garlicbread * 110) + (garlicbreadcheese * 140) +
                (brownie * 90) + (lavacake * 120) + (vanilla * 50) + (chocolate * 60) + (strawberry * 55) + (gulab * 40) +
                (cocacola * 40) + (pepsi * 40) + (sprite * 40) + (fanta * 40) + (thumsup * 40) + (dew * 40) +
                (espresso * 100) + (cappuccino * 120) + (latte * 150) + (americano * 110) + (mocha * 130) + (coldcoffee * 90) +
                (chocoshake * 120) + (vanillashake * 100) + (strawberryshake * 110) + (mangoshake * 130) + (oreoshake * 150) + (coldcoffeeshake * 140) +
                (lemonade * 60) + (icedtea * 70) + (mojito * 80) + (coldcoffeeother * 90) + (fruitpunch * 100) + (mintcooler * 70);

        // Get username from session
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        //  HTML + CSS
        out.println("<html><head><title>Order Summary</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background: #f4f4f4; text-align:center; }");
        out.println(".box { background:white; padding:25px; margin:60px auto; width:350px; border-radius:12px; box-shadow:0 0 12px gray; }");
        out.println(".item { margin:8px 0; }");
        out.println(".total { margin-top:15px; font-size:22px; font-weight:bold; color:green; }");
        out.println("a { display:inline-block; margin-top:15px; padding:10px 15px; background:orange; color:white; text-decoration:none; border-radius:5px; }");
        out.println("a:hover { background:darkorange; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='box'>");
        out.println("<h2>🧾 Order Summary</h2>");
        out.println("<p><b>Customer:</b> " + user + "</p>");

        // Show ordered items
        show(out, "Classic Pizza", classic);
        show(out, "Paneer Pizza", paneer);
        show(out, "Veg Burger", vegclassic);
        show(out, "French Fries", frenchfries);
        show(out, "Chocolate Shake", chocoshake);
        show(out, "Coca Cola", cocacola);

        out.println("<div class='total'>Total: ₹" + total + "</div>");
        out.println("<a href='categories'>🔄 Order Again</a>");
        out.println("</div>");

        out.println("</body></html>");
    }

    private int getValue(HttpServletRequest req, String name) {
        String val = req.getParameter(name);
        return (val != null && !val.isEmpty()) ? Integer.parseInt(val) : 0;
    }

    private void show(PrintWriter out, String item, int qty) {
        if (qty > 0) {
            out.println("<div class='item'>" + item + ": " + qty + "</div>");
        }
    }
}