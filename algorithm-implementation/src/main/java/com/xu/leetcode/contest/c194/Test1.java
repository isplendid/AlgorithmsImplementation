package com.xu.leetcode.contest.c194;

import com.xu.algs.basic.In;
import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by sop on 2020/6/21.
 */
public class Test1 {
    public String[] getFolderNames(String[] names) {
       String[] res = new String[names.length];
       HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<names.length; i++){
            if(map.containsKey(names[i])){  // key重复
                int value = map.get(names[i]);
                map.put(names[i], value + 1);
                res[i]= new StringBuilder(names[i]).append("(").append(map.get(names[i])).append(")").toString();  //替换掉
                map.put(res[i], 0);
            }else {

                Pair<String, Integer> entry  = extract(names[i]);
                if(map.containsKey(entry.getKey()) && !names[i].contains("(")){ //前缀重复
                    map.put(entry.getKey(), map.get(entry.getKey()) + 1);
                    res[i] = new StringBuilder(entry.getKey()).append("(").append(map.get(entry.getKey())).append(")").toString();
                } if(map.containsKey(entry.getKey()) && names[i].contains("(")){
                    map.put(entry.getKey(), map.get(entry.getKey()) + 1);
                    res[i] = names[i]; //不重复
                } else {
                    res[i] = names[i]; //不重复
                }
                map.put(names[i], 0);
                map.put(res[i],0);
            }
        }
        return res;

    }

    private Pair<String, Integer> extract(String str){
        if(!str.contains("(")){
            return new Pair<>(str, 0);
        }else {
            return new Pair(str.substring(0,str.lastIndexOf("(")),Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.lastIndexOf(")"))));
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"kaido","kaido(1)","kaido","kaido(1)"}; //
        String[] strs2 = new String[] {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        String[] strs3 = new String[]{"m","m(3)","m"};  //m, m(3),
        // "wano","wano","wano","wano"
        //["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
        //["kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)"]



        Test1 t = new Test1();

//        String strtet  = "Onest(100)(2)";
//        System.out.println(t.extract(strtet).getKey());
//        System.out.println(t.extract(strtet).getValue());

        String[] res = t.getFolderNames(strs2);
        for(String r:res){
            System.out.println(r);
        }

    }
}
