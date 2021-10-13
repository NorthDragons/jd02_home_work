package by.it_academy.controller.web.servlets.depricated;/* created by Kaminskii Ivan
 */

import by.it_academy.model.hibernate.EmployeeQuery;
import by.it_academy.service.sql.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "finder", urlPatterns = "/findEmp")
public class FindEmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService;

    public FindEmployeeServlet() {
        employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double salary =Double.parseDouble(req.getParameter("salary"));
        String name = req.getParameter("name");
//        String mode = req.getParameter("mode");
        String mode= "more";
        final List<EmployeeQuery> employee = employeeService.findEmployee(name, salary, mode);
        req.setAttribute("allEmployers", employee);
        req.getRequestDispatcher("mail/allEmp.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
