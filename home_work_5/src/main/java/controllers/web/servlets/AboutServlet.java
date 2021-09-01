package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import service.AboutService;
import storage.EStorageType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "about", urlPatterns = "/about")
public class AboutServlet extends HttpServlet {
    private static AboutService aboutService;

    public AboutServlet() {
        aboutService = AboutService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("userStorageType", aboutService.getStorageType("user").toString());
        req.setAttribute("chatStorageType", aboutService.getStorageType("chat").toString());
        req.setAttribute("dateStart", aboutService.getStartTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy/hh:mm:ss")));
        req.getRequestDispatcher("mail/about.jsp").forward(req, resp);
    }
}
