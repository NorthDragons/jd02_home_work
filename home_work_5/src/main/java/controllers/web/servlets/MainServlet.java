package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "Guide", urlPatterns = "/hello")
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new IllegalAccessError("Ошибка безопасности");
        }
        req.setAttribute("login", user.getLogin());
        req.getRequestDispatcher("/mail/main.jsp").forward(req, resp);
    }
}
