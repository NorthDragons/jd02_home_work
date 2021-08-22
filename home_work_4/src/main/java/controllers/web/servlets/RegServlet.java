package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.UserDto;
import service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = ("MailRegServlet"), urlPatterns = ("/reg"))
public class MailRegServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String BIRTHDAY = "birthday";

    private final MailService mailService;

    public MailRegServlet() {
        mailService = MailService.getInstance();
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
        String middleName = req.getParameter(MIDDLE_NAME);
        String birthday = req.getParameter(BIRTHDAY);

        UserDto userDto = new UserDto(login, password, firstName, lastName, middleName, birthday);

        this.mailService.signUp(userDto);
        req.getSession().setAttribute("user", userDto);
        resp.sendRedirect(req.getContextPath() + "/hello");

    }

    public MailService getMailService() {
        return mailService;
    }
}