package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Position implements Serializable {
    private static final Position instance=new Position();
    private String name;
    private Long id;

public static Position getInstance(){
    return instance;
}
}
