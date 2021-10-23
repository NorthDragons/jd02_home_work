package by.it_academy.model;/* created by Kaminskii Ivan
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "parent_dep", referencedColumnName = "id")
    private Department parent_dep;

//    @Column(name = "parent_dep")
//    private String parent_dep1;

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

    public Department getParent_dep() {
        return parent_dep;
    }

    public void setParent_dep(Department parent_dep) {
        this.parent_dep = parent_dep;
    }

//    public String getParent_dep1() {
//        return parent_dep1;
//    }

//    public void setParent_dep1(String parent_dep1) {
//        this.parent_dep1 = parent_dep1;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentDep=" + parent_dep.getId() +
                '}';
    }
}
