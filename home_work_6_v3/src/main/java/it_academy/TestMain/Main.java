package it_academy.TestMain;/* created by Kaminskii Ivan
 */

import it_academy.service.api.IDepService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service.xml", "storage.xml");

        final IDepService bean = context.getBean(IDepService.class);

    }
}
