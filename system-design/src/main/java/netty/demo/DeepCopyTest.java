package netty.demo;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xushichao
 * @date 2023/2/17 16:44
 * @desc
 */
public class DeepCopyTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student {
        private Integer id;
        private String name;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Teacher {
        private String name;
        private Integer id;
        private List<Student> studentList;


    }

    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("xsc");
        teacher.setStudentList(Arrays.asList(new Student(11,"xscst")));

        System.out.println(JSON.toJSON(teacher));


        //浅拷贝 BeanUtils.copyProperties();
    }
}
