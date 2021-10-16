package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;
import by.it_academy.service.sql.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "emp", urlPatterns = "/employeeActual")
public class EmployeeServletActual extends HttpServlet {
    private static EmployeeService employeeService;
//    private ObjectMapper mapper = new ObjectMapper();

    public EmployeeServletActual() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employee_mode", true);

        boolean all_emp;
        all_emp = Boolean.parseBoolean(req.getParameter("all"));
        if (all_emp) {
            Long page = Long.parseLong(req.getParameter("page"));
            Long limit = 15L;
            Long offset = employeeService.getOffset(page, limit);
            Long maxPage = employeeService.getMaxPage(limit);
            Collection<Employee> employees = employeeService.getAllEmp(limit, offset);
            req.setAttribute("title", "All_employee");
            req.setAttribute("allEmployers", employees);
            req.setAttribute("active", 4);
            req.setAttribute("page", page);
            req.setAttribute("maxPage", maxPage);
            req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
        } else {
            Long id = Long.valueOf(req.getParameter("id"));
            Employee employee = employeeService.getEmp(id);
            String posName = employeeService.getPosName(employee.getPosition());
            String depName = employeeService.getDepName(employee.getDepartment());
            req.setAttribute("title", "employee");
            req.setAttribute("employee", employee);
            req.setAttribute("position", posName);
            req.setAttribute("department", depName);
            req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);

        }

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
        resp.sendRedirect(req.getContextPath() + "/employeeActual?id=" + empId);
    }
}