package it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.service.DepServiceInitializer;
import it_academy.service.api.IDepService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "dep", urlPatterns = "/department")
public class DepartmentServlet extends HttpServlet {
    private static IDepService departmentService;

    public DepartmentServlet() {
        departmentService = DepServiceInitializer.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");
        if (action == null || action.equals("1")) {
            Collection<Department> departments;
            departments = departmentService.getAllDepartment();

            req.setAttribute("entity", "Отделы");
            req.setAttribute("allEnt", departments);
            req.getRequestDispatcher("mail/allEnt.jsp").forward(req, resp);
        } else if (action.equals("2")) {
            Department department = departmentService.getDepartment(Long.parseLong(req.getParameter("id")));
            Department parentDep = department.getParentDep();
            req.setAttribute("name", "Сотрудник");
            req.setAttribute("entity", department);
            req.setAttribute("parentDep", parentDep);
            req.getRequestDispatcher("mail/entityCard.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Long parId = Long.parseLong(req.getParameter("parId"));
        Department department = new Department();
        department.setName(name);
        Long depId = departmentService.putDepartment(department, parId);
        resp.sendRedirect(req.getContextPath() + "/department?id=" + depId);
    }
}
