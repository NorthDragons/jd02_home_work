package model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Employer implements Serializable {
    private static Employer instance = new Employer();

    private  String name;
    private  Double salary;
    private  Long position;
    private  Long department;
    private  Long id;

    public static Employer getInstance(){
        return instance;
    }
}
