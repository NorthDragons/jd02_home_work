package model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Position implements Serializable {
    private static String name;

    public Position(String name1) {
        name = name1;
    }
}
