package it_academy.controller.web.listeners;/* created by Kaminskii Ivan
 */

import it_academy.service.DepServiceInitializer;
import it_academy.service.EInitializer;
import it_academy.service.EmpServiceInitializer;
import it_academy.service.PosServiceInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    public Initializer() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EInitializer initializer = EInitializer.valueOf(sce.getServletContext().getInitParameter("service_mode"));

        DepServiceInitializer.setServiceMode(initializer);
        PosServiceInitializer.setServiceMode(initializer);
        EmpServiceInitializer.setServiceMode(initializer);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
