package by.it_academy.controller.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.service.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "allPos", urlPatterns = "/allPos")
public class AllPositionServlet extends HttpServlet {
    private static PositionService positionService;

    public AllPositionServlet() {
        positionService = PositionService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long page = Long.parseLong(req.getParameter("page"));

        Long limit = 20L;
        Long offset = positionService.getOffset(page, limit);
        Long maxPage = positionService.getMaxPage(limit);

        Collection<Position> positions = positionService.getAllPosition();
        req.setAttribute("positions", positions);
        req.setAttribute("active", 3);
        req.setAttribute("page",page);
        req.setAttribute("maxPage", maxPage);

        req.getRequestDispatcher("mail/allPos.jsp").forward(req, resp);

    }
}
