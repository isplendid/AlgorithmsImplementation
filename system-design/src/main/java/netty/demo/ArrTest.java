package netty.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xushichao
 * @date 2023/2/3 14:48
 * @desc
 */
public class ArrTest {
    public static void main(String[] args) {
//        String[] strs = new String[] {null, null};
//
//        System.out.println("strs: "+strs );
//        System.out.println("length: "+ strs.length);
//
//        String value = ",,,,340,360";
//        String[] vs= value.split(",");
//        Arrays.stream(vs).forEach(System.out::println);
//        System.out.println("--------------------------");
//        List<Integer> intVs = Stream.of(vs).map(Integer::parseInt).collect(Collectors.toList());
//
//        System.out.println(intVs);

        Object[] larr = new Object[]{null, "1", ""};
        ArrTest test = new ArrTest();
       test.getLongValues(larr);

    }

    private void getLongValues(Object[] larr){
        for(int i=0; i<larr.length; i++){
            if(larr[i] instanceof Number) {
                long val= ((Number)larr[i]).longValue();
                System.out.println(val);
            }else if(larr[i] instanceof CharSequence){
                long val = Long.parseLong(larr[i].toString());
                System.out.println("val: "+val);
            }else {
                System.out.println("default");
            }
        }
    }
}
