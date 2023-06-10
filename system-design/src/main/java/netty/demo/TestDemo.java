package netty.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushichao
 * @date 2023/1/16 21:29
 * @desc
 */
public class TestDemo {


    public static void main(String[] args) {
        Object vv = 2.4;
        Double d = (Double)vv;
        System.out.println(d);
    }

    public static void main1(String[] args) {
        List<Double> values = new ArrayList<>();
        values.add(1.0);
        values.add(2.1);
        values.add(3.2);

        Object  obj = values;

        System.out.println(obj.getClass());

        List<Double> nv = (List<Double>) obj;
        for(Double v : nv){
            System.out.println(v);
        }
    }
}
