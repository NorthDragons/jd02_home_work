package storage;/* created by Kaminskii Ivan
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.Getter;
import storage.api.IPooledData;

import java.beans.PropertyVetoException;

@Getter
public class PooledDataStorage implements IPooledData {
    private static final PooledDataStorage instance = new PooledDataStorage();
    private static ComboPooledDataSource cpds;

    static {
        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass("org.postgresql.Driver"); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl("jdbc:postgresql://localhost/testdb");
        cpds.setUser("dbuser");
        cpds.setPassword("dbpassword");
    }

    public static ComboPooledDataSource getInstance() {
        return cpds;
    }
}
