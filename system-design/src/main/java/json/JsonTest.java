package json;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xushichao
 * @date 2022/9/7 10:22
 * @desc
 */
public class JsonTest {

    public static void main(String[] args) {
//        Student student = new Student(1, "xushichao","first");
//        System.out.println(student.getObject());
//
//        Map<String,String> map =new HashMap<>();

        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("xushichao");

        String res =String.join("\',\'", set);
        System.out.println(res);



    }


}
