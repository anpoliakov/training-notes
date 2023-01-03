package logic;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String name = null;
        Integer cost = null;

        if(cart == null){
            try{
                name = request.getParameter("name");
                cost = Integer.parseInt(request.getParameter("cost"));
            }catch (NumberFormatException e){
                System.err.println("Вы не ввели атрибуты запроса!");
                request.getRequestDispatcher("/errorJsp.jsp").forward(request,response);
            }

            cart = new Cart();
            cart.setName(name);
            cart.setCost(cost);
        }

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("/cartJsp.jsp").forward(request,response);
    }
}
