package controllers.web.listeners;/* created by Kaminskii Ivan
 */

import storage.ChatStorageInitializer;
import storage.EStorageType;
import storage.UserStorageInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EStorageType chatStorage = EStorageType.valueOf(sce.getServletContext().getInitParameter("chat_storage"));
        EStorageType userStorage = EStorageType.valueOf(sce.getServletContext().getInitParameter("user_storage"));

        ChatStorageInitializer.setStorageTipe(chatStorage);
        UserStorageInitializer.setStorageTipe(userStorage);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
