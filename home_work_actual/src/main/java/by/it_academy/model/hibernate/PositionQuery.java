package by.it_academy.model.hibernate;/* created by Kaminskii Ivan
 */

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PositionQuery implements Serializable {
    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
