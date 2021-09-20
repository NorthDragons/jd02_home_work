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

@WebServlet(name = "allEmp", urlPatterns = "/allEmp")
public class AllEmployeeServlet extends HttpServlet {
    private static EmployeeService employeeService;

    public AllEmployeeServlet() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Employee> employees = employeeService.getAllEmp();
        req.setAttribute("allEmployers", employees);
        req.getRequestDispatcher("mail/allEmp.jsp").forward(req, resp);
    }
}
