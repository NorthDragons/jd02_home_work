package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Department implements Serializable {
    private static Long id;
    private static String dName;
    private static Long parentId;

}
