package by.it_academy.second.config;/* created by Kaminskii Ivan
 */

import by.it_academy.second.PersonService;
import by.it_academy.second.api.IPersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//класс с настройками нашего приложения (нету бизнес логики)
@Configuration
public class ServiceConfig {

    @Bean
    public IPersonService personServiceSingleton(){
        return new PersonService();
    }

    @Bean
    public IPersonService personService(){
            return new PersonService();
        }


    }


