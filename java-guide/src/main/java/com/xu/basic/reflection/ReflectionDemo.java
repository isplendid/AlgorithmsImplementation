package com.xu.basic.reflection;

import com.xu.basic.reflection.annotation.AlgorModelEndPoint;
import com.xu.basic.reflection.annotation.AlgorithmVersion;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

import static org.reflections.scanners.Scanners.*;

/**
 * @author xushichao
 * @date 2022/2/9 1:59 PM
 * @desc
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.xu.basic.reflection");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(ReflectionDemo.class).asClass());
        System.out.println(subTypes);
        //Set<Class<?>> annotated = reflections.get(SubTypes.of(TypesAnnotated.with())

        // SubTypes
        Set<Class<?>> modules = reflections.get(SubTypes.of(AlgorDemo.class).asClass());

// TypesAnnotated (*1)
        Set<Class<?>> versions = reflections.get(TypesAnnotated.with(AlgorithmVersion.class).asClass());
        System.out.println("versions: " + versions);


//      // MethodsAnnotated
//        Set<Method> resources = reflections.get(MethodsAnnotated.with(GetMapping.class).as(Method.class));

// FieldsAnnotated
        Set<Field> endPoints = reflections.get(FieldsAnnotated.with(AlgorModelEndPoint.class).as(Field.class));
        System.out.println("endPoints: " + endPoints);

// Resources
        Set<String> properties = reflections.get(Resources.with(".*\\.properties"));
    }
}

