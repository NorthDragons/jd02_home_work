package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dep", urlPatterns = "/department")
public class DepartmentServlet extends HttpServlet {
    private static DepartmentService departmentService;

    public DepartmentServlet() {
        departmentService = DepartmentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = departmentService.getDepartment(Long.parseLong(req.getParameter("id")));
        Department parentDep = department.getParentDep();
        req.setAttribute("department", department);
        req.setAttribute("parentDep", parentDep);
        req.getRequestDispatcher("mail/dep.jsp").forward(req, resp);

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
