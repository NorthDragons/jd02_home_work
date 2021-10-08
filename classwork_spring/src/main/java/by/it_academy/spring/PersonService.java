package by.it_academy.spring;/* created by Kaminskii Ivan
 */

import by.it_academy.spring.api.IPersonService;

public class PersonService implements IPersonService {
    @Override
    public String getHello() {
        return "Привет, меня зовут Иван";
    }
}
