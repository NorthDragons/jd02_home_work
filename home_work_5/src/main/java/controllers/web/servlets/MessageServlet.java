package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.Message;
import model.User;
import service.MailMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "messageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {
    MailMessageService service;

    public MessageServlet() {
        this.service = MailMessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/mail/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new IllegalAccessError("Ошибка безопасности");
        }
        MailMessageService service2 = MailMessageService.getInstance();
        String recipient = req.getParameter("user");
        String text = req.getParameter("message");

        Message message = new Message(user.getLogin(), text);
        service2.addMessage(recipient, message);

        resp.sendRedirect(req.getContextPath() + "/hello");
    }
}
