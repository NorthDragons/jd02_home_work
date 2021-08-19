package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Date;

@WebServlet(name = ("MailRegServlet"), urlPatterns = ("/registration"))
public class MailRegServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTHDAY = "birthday";

    private final MailService service;

    public MailRegServlet() {
        service = MailService.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/mail/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        ZonedDateTime birthday = ZonedDateTime.parse(req.getParameter(BIRTHDAY));


        service.addUsers(login, password,firstName,lastName,birthday);

        PrintWriter writer = resp.getWriter();
        writer.write(login);
    }

    public MailService getService() {
        return service;
    }
}
