package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = ("MailMain"), urlPatterns = ("/"))
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        String contextPath = req.getContextPath();
        if ((session != null) && (session.getAttribute("user") != null)) {
            resp.sendRedirect(contextPath + "/hello");
        }
        else {
            req.getRequestDispatcher("/mail/main.jsp").forward(req, resp);
        }
        }
}
