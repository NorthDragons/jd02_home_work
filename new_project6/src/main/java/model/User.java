package model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class User implements Serializable {
    private static String name;
    private static Double salary;

    public User(String name1, Double salary1) {
        name=name1;
        salary=salary1;
    }
}
