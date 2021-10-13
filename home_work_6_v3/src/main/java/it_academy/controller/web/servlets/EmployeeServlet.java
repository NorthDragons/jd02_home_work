package it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.model.Employee;
import it_academy.model.Position;
import it_academy.service.EmpServiceInitializer;
import it_academy.service.api.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@WebServlet(name = "emp", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static IEmpService employeeService;
//    private ObjectMapper mapper = new ObjectMapper(); // для работы с json

    public EmployeeServlet() {
        employeeService = EmpServiceInitializer.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Employee> employees = new ArrayList<>();
        Long limit = 15L;
        Long page = Long.parseLong(req.getParameter("page"));
        Long offset = employeeService.getOffset(page, limit);
        HashMap<Long, Collection<Employee>> paginSearch = new HashMap<>();


        if (null != req.getParameter("id")) {
            employees = employeeService.getEmp(Long.parseLong(req.getParameter("id")));
            for (Employee employee : employees) {
                String posName = employeeService.getPosName(employee.getPosition());
                String depName = employeeService.getDepName(employee.getDepartment());
                req.setAttribute("position", posName);
                req.setAttribute("department", depName);
            }
        }

        if (null != req.getParameter("name")) {
            employees = employeeService.getEmpByName(req.getParameter("name"));

        }

        req.setAttribute("employees", employees);
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
        resp.sendRedirect(req.getContextPath() + "/employee?id=" + empId);
    }
}