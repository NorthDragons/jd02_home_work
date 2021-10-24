package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.DepServiceInitializer;
import by.it_academy.service.api.IDepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "dep", urlPatterns = "/departmentActual")
public class DepartmentServletActual extends HttpServlet {
    private static IDepartmentService departmentService;

    public DepartmentServletActual() {
        departmentService = DepServiceInitializer.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("department_mode", true);
        String get_mode = req.getParameter("get_mode");
        String id = req.getParameter("id");
        switch (get_mode) {
            case ("one"):
                if (id == null || id.isBlank()) {
                    req.setAttribute("title", "Получить карточку отдела");
                    req.getRequestDispatcher("mail/resources/getEntityBody.jsp").forward(req, resp);
                } else {
                    Department department = departmentService.getDepartment(Long.parseLong(id));
                    Department parentDep = department.getParent_dep();
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long depId;
        String put_mode = req.getParameter("put_mode");
        String name = req.getParameter("name");
        String parentId = req.getParameter("parId");
        long parId = 0L;
        Department department;
        switch (put_mode) {
            case ("add"):
                department = new Department();
                if (!parentId.isBlank()) {
                    parId = Long.parseLong(parentId);
                }
                department.setName(name);
                depId = departmentService.putDepartment(department, parId);
                break;
            case ("update"):
                Long id = Long.valueOf(req.getParameter("id"));
                department = departmentService.getDepartment(id);
                if(department==null){
                    throw new IllegalStateException("Отдел с ID:"+id+" - не найден");
                }
                if (!parentId.isBlank()) {
                    parId = Long.parseLong(parentId);
                }
                if(!name.isBlank()){
                    department.setName(name);
                }
                depId = departmentService.updateDepartment(department, parId);
                break;
            default:
                throw new IllegalStateException("Не определен put_mode");
        }
        resp.sendRedirect(req.getContextPath() + "/departmentActual?get_mode=one&id=" + depId);
    }
}
