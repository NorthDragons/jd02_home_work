package by.it_academy.model.sql;/* created by Kaminskii Ivan
 */

import java.io.Serializable;

public class EmployeeBody implements Serializable {
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeBody() {
    }

    private String name;

    private Double salary;
}
