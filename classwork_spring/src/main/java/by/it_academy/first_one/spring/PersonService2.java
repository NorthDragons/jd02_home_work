package by.it_academy.spring;/* created by Kaminskii Ivan
 */

import by.it_academy.spring.api.IPersonService;

public class PersonService2 implements IPersonService {
    @Override
    public String getHello() {
        return "Привет человек 2";
    }
}
