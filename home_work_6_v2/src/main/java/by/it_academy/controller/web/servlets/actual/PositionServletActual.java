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
        String get_mode = req.getParameter("get_mode");
        String id = req.getParameter("id");
        switch (get_mode) {
            case ("one"):
                if (id == null || id.isBlank()) {
                    req.setAttribute("title", "Получить карточку должности");
                    req.getRequestDispatcher("mail/resources/getEntityBody.jsp").forward(req, resp);
                } else {
                    Position position = positionService.getPosition(Long.parseLong(id));
                    req.setAttribute("position", position);
                    req.setAttribute("title", "Должность");
                    req.getRequestDispatcher("mail/entityСard.jsp").forward(req, resp);
                }
                break;
            case ("all"):
                Long page = Long.parseLong(req.getParameter("page"));
                Long limit = 15L;
                Long offset = positionService.getOffset(page, limit);
                Long maxPage = positionService.getMaxPage(limit);
                Collection<Position> positions = positionService.getAllPosition(limit, offset);
                req.setAttribute("positions", positions);
                req.setAttribute("active", 3);
                req.setAttribute("page", page);
                req.setAttribute("maxPage", maxPage);
                req.setAttribute("title", "Должности");
                req.getRequestDispatcher("mail/allEntity.jsp").forward(req, resp);
                break;
            case "add":
                req.setAttribute("put_mode", "add");
                req.setAttribute("title", "Добавить новую должность");
                req.getRequestDispatcher("mail/addNewEntity.jsp").forward(req, resp);
                break;
            case "update":
                req.setAttribute("put_mode", "update");
                req.setAttribute("title", "Редактировать должность");
                req.getRequestDispatcher("mail/entityUpdate.jsp").forward(req, resp);
                break;
            default:
                throw new IllegalStateException("Не определён get_mode");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String put_mode = req.getParameter("put_mode");
        switch (put_mode) {
            case ("add"):
                String name = req.getParameter("name");
                Position position = new Position();
                position.setName(name);
                Long posId = positionService.putPosition(position);
                resp.sendRedirect(req.getContextPath() + "/positionActual?get_mode=one&id=" + posId);
                break;
            case ("update"):
                break;
            default:
                throw new IllegalStateException("Не определён put_mode");
        }
    }
}
