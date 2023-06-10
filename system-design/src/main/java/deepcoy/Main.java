package deepcoy;

import org.apache.commons.lang3.SerializationUtils;

import java.util.HashMap;

/**
 * @author xushichao
 * @date 2023/2/19 11:17
 *
 *
 * https://www.baeldung.com/java-copy-hashmap
 *
 * 性能对比：https://zhuanlan.zhihu.com/p/260117694
 * https://km.sankuai.com/page/1211591995
 * @desc
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        HashMap<String, Employee> map = new HashMap<>();
        Employee emp1 = new Employee("John");
        Employee emp2 = new Employee("Norman");
        map.put("emp1", emp1);
        map.put("emp2", emp2);

//        HashMap<String, Employee> shallowCopy = // shallow copy implementation
//                assertThat(shallowCopy).isNotSameAs(map);
//
//        emp1.setFirstName("Johny");
//        assertThat(shallowCopy.get("emp1")).isEqualTo(map.get("emp1"));
//
//
//
//
//        HashMap<String, Employee> deepCopy = // deep copy implementation
//
//                emp1.setFirstName("Johny");
//
//        assertThat(deepCopy.get("emp1")).isNotEqualTo(map.get("emp1"));


//        HashMap<String, Employee> deepCopy = SerializationUtils.clone(map);

        Employee copy1 = emp1.clone();
        System.out.println(copy1);


    }
}
