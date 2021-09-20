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

@WebServlet(name = "dep", urlPatterns = "/department")
public class DepartmentServlet extends HttpServlet {
    private static DepartmentService departmentService;

    public DepartmentServlet() {
        departmentService = DepartmentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = departmentService.getDepartment(Long.parseLong(req.getParameter("id")));
        req.setAttribute("department", department);
        req.getRequestDispatcher("mail/dep.jsp").forward(req, resp);

    }
}
