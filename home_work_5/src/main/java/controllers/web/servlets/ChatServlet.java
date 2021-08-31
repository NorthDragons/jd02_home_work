package controllers.web.servlets;/* created by Kaminskii Ivan
 */

import model.Message;
import model.User;
import service.MailMessageService;
import service.api.IMessageService;
import storage.MemoryChatStorage;
import storage.api.IChatStorage;

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
    IChatStorage chatStorage;

    public ChatServlet() {
        this.messageService = MailMessageService.getInstance();
        this.chatStorage= MemoryChatStorage.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            throw new IllegalAccessError("юзер нуль");
        }

        String login = user.getLogin();
        List<Message> messageList = this.chatStorage.getMessage(login);
        StringBuilder text=new StringBuilder();
        for (Message message : messageList) {
            text.append(message.toString());
        }
        req.setAttribute("chat", text);
        req.getRequestDispatcher("/mail/chat.jsp").forward(req, resp);

    }
}
