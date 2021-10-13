package by.it_academy.controller.web.servlets.depricated;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;
import by.it_academy.service.sql.EmployeeService;
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
        Employee employee = new Employee();
        Department department = new Department();
        Position position = new Position();

        String name = req.getParameter("name");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        Long posId = Long.parseLong(req.getParameter("posId"));
        Long depId = Long.parseLong(req.getParameter("depId"));
        employee.setName(name);
        employee.setSalary(salary);
        department.setId(depId);
        position.setId(posId);
        employee.setDepartment(department);
        employee.setPosition(position);
        final Long empId = employeeService.putEmployer(employee);
        resp.sendRedirect(req.getContextPath() + "/employee?id="+empId);
    }
}