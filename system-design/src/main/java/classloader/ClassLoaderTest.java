package classloader;

/**
 * @author xushichao
 * @date 2023/4/15 17:04
 * @desc
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
    }
}
