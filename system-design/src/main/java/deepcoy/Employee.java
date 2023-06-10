package deepcoy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xushichao
 * @date 2023/2/19 11:16
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Cloneable{
    private String name;


    public Employee clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        return employee;
    }
}
