package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.TreeMultimap;

/**
 * @author xushichao
 * @date 2023/2/22 19:49
 * @desc
 */
public class TestMultiMap {

    public static void main(String[] args) {
        ListMultimap<Integer,Integer> map = ArrayListMultimap.create();

        map.put(2, 4);
        map.put(1, 2);
        map.put(1, 3);
        map.put(2, 6);
        map.put(2, 4);
        map.put(3, 7);
        map.put(11, 12);
        map.put(21, 16);

        System.out.println(map);
        //{1=[2, 3], 2=[4, 6], 3=[7,9], 6=[11], 11=[12], 21=[16]}


        ListMultimap<Integer,Integer> map2 = ArrayListMultimap.create();

        map2.put(2, 4);
        map2.put(1, 2);
        map2.put(1, 3);
        map2.put(2, 6);

        System.out.println(map2);


        System.out.println(map);

    }
}
