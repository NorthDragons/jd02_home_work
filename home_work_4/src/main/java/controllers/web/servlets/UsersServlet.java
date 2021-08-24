package controllers.web.servlets;

import model.User;
import service.MailRegService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    MailRegService mailService;

    public UsersServlet() {
        this.mailService = MailRegService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=UTF-8");
        Collection<User> users = mailService.getAll();
        for (User user : users) {
            writer.println(user+"\n");
        }
    }
}
