package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.Message;
import model.User;
import service.MailMessageService;
import service.api.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "chatServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
    IMessageService messageService;

    public ChatServlet() {
        this.messageService = MailMessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new IllegalAccessError("юзер нуль");
        }

        String login = user.getLogin();
        List<Message> messageList = this.messageService.get(user);
        StringBuilder text = new StringBuilder();
        if (messageList != null) {
            for (Message message : messageList) {
                text.append(message.toString());
            }
        } else {
            text.append("Ты случаем не полковник?");
        }

        req.setAttribute("chat", text);
        req.getRequestDispatcher("/mail/chat.jsp").forward(req, resp);

    }
}
