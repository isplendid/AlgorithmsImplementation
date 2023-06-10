package com;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.PrimitiveSink;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushichao
 * @date 2023/3/27 20:05
 * @desc
 */
public class BloomFilterTest {

    public void testBloom() {
        // 初始化一个存储string数据的布隆过滤器，初始化大小1w, 错误率为0.1%
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000, 0.001);

        // 添加数据
        bloomFilter.put("hello world!");

        // 判断是否存在，false则表示一定不存在； true表示可能存在
        boolean ans = bloomFilter.mightContain("hello world!");
        System.out.println(ans);  //true

        ans = bloomFilter.mightContain("hello world");
        System.out.println(ans); //false
    }


    public void testBloom2() {
        BloomFilter<Map> bloomFilter = BloomFilter.create(new Funnel<Map>() {
            @Override
            public void funnel(Map map, PrimitiveSink primitiveSink) {
                primitiveSink.putString(map.toString(), Charsets.UTF_8);
            }
        }, 1000, 0.001);

        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        bloomFilter.put(map);

        map.put("a", "");
        bloomFilter.put(map);

        // 判断是否存在，false则表示一定不存在； true表示可能存在
        boolean ans = bloomFilter.mightContain(map);
        System.out.println(ans);  //true

        map.put("a", "c");
        ans = bloomFilter.mightContain(map);
        System.out.println(ans); //false
    }

    public static void main(String[] args) {

        BloomFilterTest test = new BloomFilterTest();
        test.testBloom2();
    }
}
