import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

/*
* При старте приложения, Tomcat подгружает сервлеты в контейнер сервлетов и начинает обрабатывать запросы от клиентов
* */
public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter writer = response.getWriter();
 
        writer.println("<html>");
        writer.println("Hello " + name + ", Good day!");
        writer.println("</html>");

        RequestDispatcher dis = request.getRequestDispatcher("/testJsp.jsp");
        dis.forward(request,response);
    }
}
