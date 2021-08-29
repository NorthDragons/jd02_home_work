package controllers.web.listeners;

import model.Message;
import model.User;
import storage.ChatsStorage;
import storage.UserStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class DefaultDataInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserStorage userStorage = UserStorage.getInstance();

        User user = new User("admin", "admin", "admin", "admin", "admin", "22.07.1999");

        userStorage.add(user);

        ChatsStorage chatStorage = ChatsStorage.getInstance();

        Message message = new Message("unknown", "мы боимся слежки");
        message.setWhen(LocalDateTime.now());
        chatStorage.addMessage(user.getLogin(), message);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
