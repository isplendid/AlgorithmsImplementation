package com.xu.basic.reflection;

import com.xu.basic.reflection.annotation.AlgorModelEndPoint;
import com.xu.basic.reflection.entry.AlgorEntryDemo;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author xushichao
 * @date 2022/2/9 2:22 PM
 * @desc
 */
public class ReflectionUtilsDemo {
    public static void main(String[] args) {

        //Fields
       Class algorV0Class = AlgorDemo.class;
        final Set<Field> fields = ReflectionUtils.getAllFields(algorV0Class, ReflectionUtils.withTypeAssignableTo(ModelOnceCaller.class), ReflectionUtils.withAnnotation(AlgorModelEndPoint.class));
        System.out.println(fields);

        //methods
        Class algroEntry = AlgorEntryDemo.class;
        Set<Method> createRoutingKeys = ReflectionUtils.getMethods(algroEntry.getClass(), ReflectionUtils.withParametersCount(1) , ReflectionUtils.<Method>withName("createRoutingKeys"));
        Set<Method> buildInput = ReflectionUtils.getMethods(algroEntry.getClass(), ReflectionUtils.withParametersCount(1)
                , ReflectionUtils.<Method>withName("buildInput"));

        System.out.println(createRoutingKeys);
        System.out.println(buildInput);




    }
}
