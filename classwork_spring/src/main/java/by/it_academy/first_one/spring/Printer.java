package by.it_academy.spring;/* created by Kaminskii Ivan
 */

import by.it_academy.spring.api.IPersonService;
import by.it_academy.spring.api.IPrinterService;

public class Printer implements IPrinterService {
    private final IPersonService personService;

    public Printer(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void print() {
        System.out.println(personService.getHello());
    }
}
