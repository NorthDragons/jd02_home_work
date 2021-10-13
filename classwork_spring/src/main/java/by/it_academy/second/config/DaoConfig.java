package by.it_academy.second.config;/* created by Kaminskii Ivan
 */

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DaoConfig {


    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        return null;
    }


    @Bean
    public DataSource dataSource(){
        return null;
    }
}
