package controllers.web.listeners;/* created by Kaminskii Ivan
 */

import service.AboutService;
import service.MailMessageService;
import storage.ChatStorageInitializer;
import storage.EStorageType;
import storage.UserStorageInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class Initializer implements ServletContextListener {
    AboutService service;

    public Initializer() {
        this.service = AboutService.getInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EStorageType chatStorage = EStorageType.valueOf(sce.getServletContext().getInitParameter("chat_storage"));
        EStorageType userStorage = EStorageType.valueOf(sce.getServletContext().getInitParameter("user_storage"));

        ChatStorageInitializer.setStorageType(chatStorage);
        UserStorageInitializer.setStorageType(userStorage);
        service.setStartTime(LocalDateTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
