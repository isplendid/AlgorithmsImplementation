package jdk.proxy;

/**
 * @author xushichao
 * @date 2023/3/30 11:46
 * @desc
 */
public class CloneTest {

    public static void main(String[] args) {
        int[] arr =  new int[10];
        arr.clone();
        int lne = arr.length;
    }
}
