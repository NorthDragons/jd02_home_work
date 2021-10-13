package by.it_academy.second;/* created by Kaminskii Ivan
 */


import by.it_academy.second.api.IPersonService;

public class PersonService implements IPersonService {
    @Override
    public String getHello() {
        return "Привет, меня зовут Иван";
    }
}
