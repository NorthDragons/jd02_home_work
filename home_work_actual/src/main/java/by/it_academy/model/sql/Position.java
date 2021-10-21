package by.it_academy.model.sql;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Position implements Serializable {
    private String name;
    private Long id;

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
