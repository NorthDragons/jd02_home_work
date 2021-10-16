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
import java.util.Collection;

@WebServlet(name = "pos", urlPatterns = "/positionActual")
public class PositionServletActual extends HttpServlet {
    private static PositionService positionService;

    public PositionServletActual() {
        positionService = PositionService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("position_mode", true);


        boolean all_pos;
        all_pos=Boolean.parseBoolean(req.getParameter("all"));
        if(all_pos){
            Long page = Long.parseLong(req.getParameter("page"));
            Long limit = 15L;
            Long offset = positionService.getOffset(page, limit);
            Long maxPage = positionService.getMaxPage(limit);
            Collection<Position> positions = positionService.getAllPosition(limit, offset);
            req.setAttribute("positions", positions);
            req.setAttribute("active", 3);
            req.setAttribute("page",page);
            req.setAttribute("maxPage", maxPage);
            req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
        }else {
            Position position = positionService.getPosition(Long.parseLong(req.getParameter("id")));
            req.setAttribute("position", position);
            req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Position position = new Position();
        position.setName(name);
        Long posId = positionService.putPosition(position);
        resp.sendRedirect(req.getContextPath() + "/positionActual?id=" + posId);
    }
}
