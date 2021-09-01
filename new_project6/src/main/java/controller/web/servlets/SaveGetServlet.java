package controller.web.servlets;/* created by Kaminskii Ivan
 */

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "save", urlPatterns = "/save")
public class SaveGetServlet extends HttpServlet {
    UserService userService;

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String BIRTHDAY = "birthday";

    public SaveGetServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String middleName = req.getParameter(MIDDLE_NAME);
        String birthday = req.getParameter(BIRTHDAY);
        this.userService.putUser();
        resp.sendRedirect(req.getContextPath() + "/hello");

    }

}
