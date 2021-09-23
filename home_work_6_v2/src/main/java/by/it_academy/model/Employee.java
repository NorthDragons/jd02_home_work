package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee implements Serializable {
    private static Employee instance = new Employee();

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "department")
    private Department department;

    @Column(name = "position")
    private Position position;

    public static Employee getInstance() {
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
