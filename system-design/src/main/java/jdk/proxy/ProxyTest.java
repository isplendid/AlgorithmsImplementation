package jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * @author xushichao
 * @date 2023/3/30 11:43
 * @desc
 */
public class ProxyTest {

    public static void main(String[] args) {
        //第一步：创建被代理对象
        HelloImpl hello = new HelloImpl();
        //第二步：创建handler,传入真实对象
        ProxyHandler handler = new ProxyHandler(hello);
        //第三步：创建代理对象，传入类加载器、接口、handler
        HelloInterface helloProxy = (HelloInterface) Proxy.newProxyInstance(
                HelloInterface.class.getClassLoader(),
                new Class[]{HelloInterface.class}, handler);
        //第四步：调用方法
        helloProxy.sayHello();
    }
}
