import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "countServlet", value = "/count")
public class countServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      float price = Float.parseFloat(request.getParameter("ListPrice"));
      float percent = Float.parseFloat(request.getParameter("DiscountPercent"));
      String description = request.getParameter("ProductDescription");
      float discount = price*percent/100;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + description + "</h1>");
        writer.println("<h1>Price: " + price + "</h1>");
        writer.println("<h1>Percent: " + percent + "</h1>");
        writer.println("<h1>Discount amount " + discount + "</h1>");
        writer.println("</html>");
    }
}
