package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    private static EmployeeService employeeService;

    public TestServlet() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Employee> employees = employeeService.getAllEmp();
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            stringBuilder.append(employee.getId());
            stringBuilder.append("<br>");
        }
        req.setAttribute("allEmployers", employees);
        req.getRequestDispatcher("mail/test.jsp").forward(req, resp);
    }
}
