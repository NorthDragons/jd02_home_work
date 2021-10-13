package by.it_academy.spring;/* created by Kaminskii Ivan
 */

import by.it_academy.spring.api.IPrinterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //область в рамках которой мы что-то делаем (действия описаны в xml файле)
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");

        final IPrinterService bean = context.getBean(IPrinterService.class);
        bean.print();
    }
}
