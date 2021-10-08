package by.it_academy.model.sql;/* created by Kaminskii Ivan
 */

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
