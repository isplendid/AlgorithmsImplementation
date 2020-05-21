package com.xu.bigdata;

import java.util.BitSet;

/**
 * Created by sop on 2020/4/5.
 */
public class SimpleBloomFilter {
    private static final int DEFAULT_SIZE = 2 << 64;
    private static final int[] seeds = new int[] { 7, 113, 213, 3111, 397, 611,532 };  //不同的函数seed
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[seeds.length];   //func 函数数组

    public SimpleBloomFilter(){
        for(int i=0; i<seeds.length; i++){
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]); //初始化func函数数组
        }
    }


    public static class SimpleHash{
        private int cap;
        private int seed;
        public SimpleHash(int cap, int seed){
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value){
            int result = 0;
            int len = value.length();
            for(int i=0; i<len; i++){
                result = seed * result + value.charAt(i); //一般的hash算法
            }
            return (cap - 1) & result; //把值 范围控制在 cap 内
        }
    }

    public void add(String url){ //bloom filter 添加url值
        for(SimpleHash f :func) {
            bits.set(f.hash(url), true);
        }
    }

    public boolean contains(String value){
        if(value == null) return false;
        boolean ret = true;
        for(SimpleHash f: func ){
            ret = ret && bits.get(f.hash(value));
        }
        return  ret;
    }


    public static void main(String[] args) {
        String[] urls = new String[]{"www.example.com","www.renren.com","www.baidu.com","www.baidu.com"};  //测试数据
        SimpleBloomFilter filter = new SimpleBloomFilter();
        for(String value : urls){
            value = value.trim();
            System.out.println("filter.contains("+value+"):"+filter.contains(value));
            filter.add(value);
            System.out.println("filter.add("+value+"):"+filter.contains(value));
            System.out.println("----------------------------------------------------");
            StringBuilder sb = new StringBuilder();
            StringBuffer sbuffer = new StringBuffer();
        }
    }
}
