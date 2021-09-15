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

@WebServlet(name = "emp", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static EmployeeService employeeService;

    public EmployeeServlet() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Employee employee = employeeService.getEmp(id);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("mail/emp.jsp").forward(req, resp);

    }
}