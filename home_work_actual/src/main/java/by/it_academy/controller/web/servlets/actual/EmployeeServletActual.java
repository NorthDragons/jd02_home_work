package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.EmpServiceInitializer;
import by.it_academy.service.api.IEmployerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "emp", urlPatterns = "/employeeActual")
public class EmployeeServletActual extends HttpServlet {
    private static IEmployerService employeeService;
//    private ObjectMapper mapper = new ObjectMapper();

    public EmployeeServletActual() {
        employeeService = EmpServiceInitializer.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employee_mode", true);
        String get_mode = req.getParameter("get_mode");
        String id = req.getParameter("id");
        switch (get_mode) {
            case ("one"):
                if (id == null || id.isBlank()) {
                    req.setAttribute("title", "Получить карточку пользователя");
                    req.getRequestDispatcher("mail/resources/getEntityBody.jsp").forward(req, resp);
                } else {
                    Employee employee = employeeService.getEmp(Long.valueOf(id));
                    if (employee.getDepartment() != null) {
                        Department department = employee.getDepartment();
                        req.setAttribute("department", department.getName());
                    } else {
                        req.setAttribute("department", "Отсутствует Отдел");
                    }
                    if (employee.getPosition() != null) {
                        Position position = employee.getPosition();
                        req.setAttribute("position", position.getName());
                    } else {
                        req.setAttribute("position", "Отсутствует Должность");
                    }
                    req.setAttribute("title", "Сотрудник");
                    req.setAttribute("employee", employee);
                    req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);
                }
                break;
            case ("all"):
                Long page = Long.parseLong(req.getParameter("page"));
                Long limit = 15L;
                Long offset = employeeService.getOffset(page, limit);
                Long maxPage = employeeService.getMaxPage(limit);
                Collection<Employee> employees = employeeService.getAllEmp(limit, offset);
                req.setAttribute("title", "Сотрудники");
                req.setAttribute("allEmployers", employees);
                req.setAttribute("active", 4);
                req.setAttribute("page", page);
                req.setAttribute("maxPage", maxPage);
                req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
                break;
            case ("add"):
                req.setAttribute("put_mode", "add");
                req.setAttribute("title", "Добавить нового сотрудника");
                req.getRequestDispatcher("mail/addNewEntity.jsp").forward(req, resp);
                break;
            case "update":
                req.setAttribute("put_mode", "update");
                req.setAttribute("title", "Редактировать сотрудника");
                req.getRequestDispatcher("mail/entityUpdate.jsp").forward(req, resp);
                break;
            default:
                throw new IllegalStateException("Не определён get_mode");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long empId;
        String put_mode = req.getParameter("put_mode");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String posId = req.getParameter("posId");
        String depId = req.getParameter("depId");
        Position position;
        Department department;
        Employee employee;
        switch (put_mode) {
            case ("add"):
                employee = new Employee();
                employee.setName(name);
                employee.setSalary((!(salary.equals(""))) ? Double.parseDouble(salary) : 0.0);
                if (!depId.isBlank()) {
                    department = new Department();
                    department.setId(Long.valueOf(depId));
                    employee.setDepartment(department);
                }
                if (!posId.isBlank()) {
                    position = new Position();
                    position.setId(Long.valueOf(posId));
                    employee.setPosition(position);
                }
                empId = employeeService.putEmployer(employee);
                break;
            case ("update"):
                empId = Long.valueOf(req.getParameter("id"));
                employee = employeeService.getEmp(empId);
                if (!name.isBlank()) {
                    employee.setName(name);
                }
                if (!salary.isBlank()) {
                    employee.setSalary(Double.parseDouble(salary));
                }
                if (!posId.isBlank()) {
                    position = employee.getPosition();
                    position.setId(Long.valueOf(posId));
                    employee.setPosition(position);
                }
                if (!depId.isBlank()) {
                    department = employee.getDepartment();
                    department.setId(Long.valueOf(depId));
                    employee.setDepartment(department);
                }
                employeeService.updateEmployer(employee);
                break;
            default:
                throw new IllegalStateException("Не определён put_mode");
        }
        resp.sendRedirect(req.getContextPath() + "/employeeActual?id=" + empId + "&get_mode=one");
    }
}