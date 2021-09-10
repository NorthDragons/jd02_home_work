package controller.web.servlets;/* created by Kaminskii Ivan
 */

import model.Employer;
import service.EmployerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "save", urlPatterns = "/save")
public class SaveGetServlet extends HttpServlet {
    private static EmployerService userService;
    private static Employer employer;

    private static final String NAME = "name";
    private static final String SALARY = "salary";

    public SaveGetServlet() {
        employer=Employer.getInstance();
        userService = EmployerService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String name = req.getParameter(NAME);
         Double salary = Double.parseDouble(req.getParameter(SALARY));
        employer.setName(name);
        employer.setSalary(salary);
        userService.putUser(employer);
        resp.sendRedirect(req.getContextPath() + "/hello");

    }

}
