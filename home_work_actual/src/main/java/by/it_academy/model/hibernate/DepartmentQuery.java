package by.it_academy.model.hibernate;/* created by Kaminskii Ivan
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DepartmentQuery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private DepartmentQuery parentDep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentQuery getParentDep() {
        return parentDep;
    }

    public void setParentDep(DepartmentQuery parentDep) {
        this.parentDep = parentDep;
    }
}
