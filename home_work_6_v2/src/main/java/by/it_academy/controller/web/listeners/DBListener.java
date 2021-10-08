package by.it_academy.controller.web.listeners;/* created by Kaminskii Ivan
 */

import by.it_academy.storage.sql.CreatDB;
import by.it_academy.storage.api.DBCreator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBCreator dbCreator= new CreatDB();
        dbCreator.depTable();
        dbCreator.posTable();
        dbCreator.empTable();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
