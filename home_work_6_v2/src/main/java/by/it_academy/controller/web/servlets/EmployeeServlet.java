package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "emp", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static EmployeeService employeeService;
    private ObjectMapper mapper = new ObjectMapper();

    public EmployeeServlet() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long id = Long.parseLong(req.getParameter("id"));
        Employee employee = employeeService.getEmp(Long.parseLong(req.getParameter("id")));
        String posName = employeeService.getPosName(employee.getPosition());
        String depName = employeeService.getDepName(employee.getDepartment());

        req.setAttribute("employee", employee);
        req.setAttribute("position", posName);
        req.setAttribute("department", depName);
        req.getRequestDispatcher("mail/emp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = mapper.readValue(req.getInputStream(), Employee.class);


        super.doPost(req, resp);
    }
}