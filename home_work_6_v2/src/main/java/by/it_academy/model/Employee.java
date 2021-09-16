package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {
    private static Employee instance = new Employee();

    private  String name;
    private  Double salary;
    private  Long id;
    private  Department department;
    private  Position position;

    public static Employee getInstance(){
        return instance;
    }

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
