import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");

        if(count == null){
            session.setAttribute("count", 1);
            count = 1;
        }else{
            session.setAttribute("count", count + 1);
        }

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<p> Your count is " + count + " </p>");
        writer.println("</html>");
    }
}
