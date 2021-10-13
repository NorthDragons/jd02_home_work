package by.it_academy.controller.web.servlets.actual;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Position;
import by.it_academy.service.sql.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "pos", urlPatterns = "/position")
public class PositionServletActual extends HttpServlet {
    private static PositionService positionService;

    public PositionServletActual() {
        positionService = PositionService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Position position = positionService.getPosition(Long.parseLong(req.getParameter("id")));
        req.setAttribute("position", position);
        req.getRequestDispatcher("mail/pos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Position position = new Position();
        position.setName(name);
        Long posId = positionService.putPosition(position);
        resp.sendRedirect(req.getContextPath() + "/position?id=" + posId);
    }
}
