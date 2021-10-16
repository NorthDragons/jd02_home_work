package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.service.sql.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "dep", urlPatterns = "/departmentActual")
public class DepartmentServletActual extends HttpServlet {
    private static DepartmentService departmentService;

    public DepartmentServletActual() {
        departmentService = DepartmentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("department_mode", true);
        int mode = Integer.parseInt(req.getParameter("mode"));
        switch (mode) {
            case (0):
                Department department = departmentService.getDepartment(Long.parseLong(req.getParameter("id")));
                Department parentDep = department.getParentDep();
                req.setAttribute("title", "department");
                req.setAttribute("department", department);
                req.setAttribute("parentDep", parentDep);
                req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);
                break;
            case (1):
                Long page = Long.parseLong(req.getParameter("page"));
                Long limit = 15L;
                Long offset = departmentService.getOffset(page, limit);
                Long maxPage = departmentService.getMaxPage(limit);
                Collection<Department> departments = departmentService.getAllDepartment(limit, offset);
                req.setAttribute("departments", departments);
                req.setAttribute("active", 2);
                req.setAttribute("page", page);
                req.setAttribute("maxPage", maxPage);
                req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
                break;
            case (2):
                break;
            default:
                throw new IllegalStateException("Не определен мод обработки запроса");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Long parId = 0L;
        if (!req.getParameter("parId").equals("")) {
            parId = Long.parseLong(req.getParameter("parId"));
        }
        Department department = new Department();
        department.setName(name);
        Long depId = departmentService.putDepartment(department, parId);
        resp.sendRedirect(req.getContextPath() + "/departmentActual?id=" + depId);
    }
}
