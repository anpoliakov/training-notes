import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //удаляем cookie на браузере клиента, передавая обязательно такое же имя и установив срок жизни = 0
        Cookie cookie = new Cookie("some_id", "");
        cookie.setMaxAge(0); //или передать -1 (тогда куки удалится только после закрытия браузера), если 0 - то немедленно
        response.addCookie(cookie);
    }
}
