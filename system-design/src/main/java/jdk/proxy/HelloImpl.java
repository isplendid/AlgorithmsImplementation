package jdk.proxy;

/**
 * @author xushichao
 * @date 2023/3/30 11:41
 * @desc
 */
public class HelloImpl implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
