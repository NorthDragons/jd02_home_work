package controllers.web.servlets;

import model.User;
import service.RegService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "usersInfo", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    RegService mailService;

    public UsersServlet() {
        this.mailService = RegService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = mailService.getAll();
        StringBuffer stringBuffer = new StringBuffer();
        for (User user : users) {
            stringBuffer.append(user.toString());
        }
        req.setAttribute("users", stringBuffer);
        req.getRequestDispatcher("mail/allUsers.jsp").forward(req, resp);
    }
}
