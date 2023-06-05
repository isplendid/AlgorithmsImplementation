package edu.xpu;

import com.google.protobuf.InvalidProtocolBufferException;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xushichao
 * @date 2023/4/4 17:37
 * @desc
 *
 */
public class ProtobufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        byte[] bytes = serialize();
        System.out.println(Arrays.toString(bytes));

        TeacherSerializer.Teacher teacher = deserialize(bytes);
        System.out.println(teacher);


    }

    private static byte[] serialize() {
       TeacherSerializer.Teacher.Builder builder = TeacherSerializer.Teacher.newBuilder();
       builder.setName("Tim")
               .setAge(34)
               .setTeacherId(1L)
               .addCourses("JAVA");
       TeacherSerializer.Teacher  teacher = builder.build();
       return teacher.toByteArray();

    }

    private static TeacherSerializer.Teacher deserialize(byte[] bytes) throws InvalidProtocolBufferException {
        return TeacherSerializer.Teacher.parseFrom(bytes);
    }
}
