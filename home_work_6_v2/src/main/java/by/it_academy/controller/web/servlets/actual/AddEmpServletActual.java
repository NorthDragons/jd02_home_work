package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", urlPatterns = "/addNewActualEmp")
public class AddEmpServletActual extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employee", true);
        req.getRequestDispatcher("mail/actual/addNewEntity.jsp").forward(req, resp);
    }
}
