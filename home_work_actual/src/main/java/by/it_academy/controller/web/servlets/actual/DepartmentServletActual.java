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
        String get_mode = req.getParameter("get_mode");
        String id = req.getParameter("id");
        switch (get_mode) {
            case ("one"):
                if(id==null || id.isBlank()){
                    req.setAttribute("title", "Получить карточку отдела");
                    req.getRequestDispatcher("mail/resources/getEntityBody.jsp").forward(req, resp);
                }else {
                    Department department = departmentService.getDepartment(Long.parseLong(id));
                    Department parentDep = department.getParentDep();
                    req.setAttribute("title", "Отдел");
                    req.setAttribute("department", department);
                    req.setAttribute("parentDep", parentDep);
                    req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);
                }
                break;
            case ("all"):
                Long page = Long.parseLong(req.getParameter("page"));
                Long limit = 15L;
                Long offset = departmentService.getOffset(page, limit);
                Long maxPage = departmentService.getMaxPage(limit);
                Collection<Department> departments = departmentService.getAllDepartment(limit, offset);
                req.setAttribute("departments", departments);
                req.setAttribute("active", 2);
                req.setAttribute("page", page);
                req.setAttribute("maxPage", maxPage);
                req.setAttribute("title", "Отделы");

                req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
                break;
            case "add":
                req.setAttribute("put_mode", "add");
                req.setAttribute("title", "Добавить новый отдел");
                req.getRequestDispatcher("mail/addNewEntity.jsp").forward(req, resp);
                break;
            case "update":
                req.setAttribute("put_mode", "update");
                req.setAttribute("title", "Редактировать отдел");
                req.getRequestDispatcher("mail/entityUpdate.jsp").forward(req, resp);
                break;
            default:
                throw new IllegalStateException("Не определен get_mode");
        }
    }

    /*
    put_mode (0) - create mode
    put_mode (1) - update mode
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String put_mode = req.getParameter("put_mode");
        switch (put_mode) {
            case ("add"):
                long parId = 0L;
                Department department = new Department();
                String name = req.getParameter("name");
                if (!req.getParameter("parId").equals("")) {
                    parId = Long.parseLong(req.getParameter("parId"));
                }
                department.setName(name);
                Long depId = departmentService.putDepartment(department, parId);
                resp.sendRedirect(req.getContextPath() + "/departmentActual?get_mode=one&id=" + depId);
                break;
            case ("update"):
                break;
            default:
                throw new IllegalStateException("Не определен put_mode");
        }
    }
}
