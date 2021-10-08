package by.it_academy.model.sql;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {


    private Long id;


    private String name;


    private Double salary;


    private Department department;


    private Position position;



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
