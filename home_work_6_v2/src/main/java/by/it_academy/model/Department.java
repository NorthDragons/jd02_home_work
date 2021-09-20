package by.it_academy.model;/* created by Kaminskii Ivan
 */

import by.it_academy.storage.DepartmentStorage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Department implements Serializable {
    private Long id;
    private String name;
    private Department parentDep;

}
