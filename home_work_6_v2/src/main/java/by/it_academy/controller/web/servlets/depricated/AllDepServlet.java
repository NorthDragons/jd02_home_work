package by.it_academy.controller.web.servlets.depricated;/* created by Kaminskii Ivan
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

@WebServlet(name = "allDep", urlPatterns = "/allDep")
public class AllDepServlet extends HttpServlet {
    private static DepartmentService departmentService;

    public AllDepServlet() {
        departmentService = DepartmentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long page = Long.parseLong(req.getParameter("page"));
        Long limit = 20L;
        Long offset = departmentService.getOffset(page, limit);
        Long maxPage = departmentService.getMaxPage(limit);
        Collection<Department> departments = departmentService.getAllDepartment(limit, offset);
        req.setAttribute("departments", departments);
        req.setAttribute("active", 2);
        req.setAttribute("page",page);
        req.setAttribute("maxPage", maxPage);
        req.getRequestDispatcher("mail/allDep.jsp").forward(req, resp);
    }
}
