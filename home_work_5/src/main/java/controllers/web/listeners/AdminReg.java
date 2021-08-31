package controllers.web.listeners;

import model.Message;
import model.User;
import storage.MemoryChatStorage;
import storage.MemoryUserStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class AdminReg implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MemoryUserStorage userStorage = MemoryUserStorage.getInstance();
        MemoryChatStorage chatStorage = MemoryChatStorage.getInstance();



        User user = new User("admin", "admin", "admin", "admin", "admin", "22.07.1999");

        Message message = new Message("unknown", "мы боимся слежки");
        message.setWhen(LocalDateTime.now());

        userStorage.add(user);
        chatStorage.addMessage(user.getLogin(), message);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
