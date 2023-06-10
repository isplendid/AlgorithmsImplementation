package com.xu.test;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author xushichao
 * @date 2023/5/9 10:05
 * @desc
 * BeanDefinition 是一个接口，继承自 BeanMetadataElement 和 AttributeAccessor 接口
 * AttributeAccessor：定义用于附加和访问元数据的通用协定的接口，可以是任意对象。具体的实现则是 AttributeAccessorSupport，采用 LinkedHashMap 进行存储。
 */
public class Main {

    public static void main(String[] args) {
        // 定义了一个BeanDefinition
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition()
                .getBeanDefinition();
        // 当前Bean对象的类型
        beanDefinition.setBeanClass(User.class);
        // 将BeanDefinition注册到BeanFactory中
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("user", beanDefinition);

        //
        // 设置作用域
        beanDefinition.setScope("prototype");
        // 设置初始化方法
        beanDefinition.setInitMethodName("init");
      // 设置自动装配模型
        beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);


        // 获取Bean
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
