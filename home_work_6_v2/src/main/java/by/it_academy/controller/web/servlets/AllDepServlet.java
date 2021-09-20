package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.DepartmentService;

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

        Collection<Department> departments = departmentService.getAllDepartment();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("mail/allDep.jsp").forward(req, resp);
    }
}
