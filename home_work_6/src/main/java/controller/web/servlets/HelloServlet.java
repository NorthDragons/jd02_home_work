package controller.web.servlets;/* created by Kaminskii Ivan
 */

import model.Employer;
import service.UserService;
import service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    private static IUserService userService;
    private static Employer employer;

    public HelloServlet() {
        userService = UserService.getInstance();
     employer= Employer.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", employer.getId());
        req.setAttribute("name", employer.getName());
        req.setAttribute("salary", employer.getSalary());
        req.getRequestDispatcher("mail/hello.jsp").forward(req, resp);
    }
}
