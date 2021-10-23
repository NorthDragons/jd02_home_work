package by.it_academy.controller.web.listeners;/* created by Kaminskii Ivan
 */

import by.it_academy.service.DepServiceInitializer;
import by.it_academy.service.EInitializer;
import by.it_academy.service.EmpServiceInitializer;
import by.it_academy.service.PosServiceInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EInitializer initializer = EInitializer.valueOf(sce.getServletContext().getInitParameter("service_mod"));
        if(!initializer.equals(EInitializer.SQL)){
            if(!initializer.equals(EInitializer.HIBERNATE)){
                initializer=EInitializer.SQL;
            }
        }
        DepServiceInitializer.setServiceMode(initializer);
        PosServiceInitializer.setServiceMode(initializer);
        EmpServiceInitializer.setServiceMode(initializer);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
