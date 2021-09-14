package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;


public class DBInitializer {
    private static final DBInitializer instance = new DBInitializer();
    private static final ComboPooledDataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
        try {

            cpds.setDriverClass("org.postgresql.Driver"); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl("jdbc:postgresql://localhost/testdb");
        cpds.setUser("dbuser");
        cpds.setPassword("dbpassword");
    }

    public ComboPooledDataSource getCpds() {
        return cpds;
    }
    public static DBInitializer getInstance(){
        return instance;
    }
}
