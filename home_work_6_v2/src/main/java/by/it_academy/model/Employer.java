package by.it_academy.model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Employer implements Serializable {
    private static Employer instance = new Employer();

    private  String name;
    private  Double salary;
    private  Long id;
    private  Department department;
    private  Position position;

    public static Employer getInstance(){
        return instance;
    }
}
