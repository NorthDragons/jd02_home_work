package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.UserDto;
import service.MailInService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    private final MailInService mailInService;

    public LogInServlet() {
        this.mailInService = MailInService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/mail/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDto user = mailInService.authentication(login, password);
        if (user == null) {
            throw new IllegalAccessError("неверный логин или пароль");
        } else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/hello");
        }

    }

}
