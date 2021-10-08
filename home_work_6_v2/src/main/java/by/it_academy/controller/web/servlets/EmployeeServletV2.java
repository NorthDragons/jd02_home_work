package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;
import by.it_academy.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "empl2", urlPatterns = "/employee2")
public class EmployeeServletV2 extends HttpServlet {
    private static EmployeeService employeeService;

    public EmployeeServletV2() {
        employeeService = EmployeeService.getInstance();
    }
/*
mode == 1 - все сотрудники
mode == 2 - получить 1 сотрудника
mode == 3 - добавить/редактировать сотрудника
 */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long mode = Long.parseLong(req.getParameter("mode"));
        if(mode==1){
            Long page = Long.parseLong(req.getParameter("page"));

            Long limit = 15L;
            Long offset = employeeService.getOffset(page, limit);
            Long maxPage = employeeService.getMaxPage(limit);

            Collection<Employee> employees = employeeService.getAllEmp(limit, offset);
            req.setAttribute("allEmployers", employees);
            req.setAttribute("active", 4);
            req.setAttribute("page",page);
            req.setAttribute("maxPage", maxPage);

            req.getRequestDispatcher("mail/allEmp.jsp").forward(req, resp);

        }
        else if(mode==2){
            Employee employee = employeeService.getEmp(Long.parseLong(req.getParameter("id")));
            String posName = employeeService.getPosName(employee.getPosition());
            String depName = employeeService.getDepName(employee.getDepartment());

            req.setAttribute("employee", employee);
            req.setAttribute("entity", "Сотрудник");
            req.setAttribute("position", posName);
            req.setAttribute("department", depName);
            req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);

        }else if(mode==3){
            req.getRequestDispatcher("mail/addNewEmp.jsp").forward(req, resp);
        }
        else {
            Employee employee = employeeService.getEmp(Long.parseLong(req.getParameter("id")));
            String posName = employeeService.getPosName(employee.getPosition());
            String depName = employeeService.getDepName(employee.getDepartment());

            req.setAttribute("employee", employee);
            req.setAttribute("position", posName);
            req.setAttribute("department", depName);
            req.getRequestDispatcher("mail/emp.jsp").forward(req, resp);
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
        resp.sendRedirect(req.getContextPath() + "/employee?id=" + empId);
    }
}