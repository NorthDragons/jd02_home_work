package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Department implements Serializable {
    private static final Department instance = new Department();
    private Long id;
    private String name;
    private Department parentDep;

    public static Department getInstance() {
        return instance;
    }
}
