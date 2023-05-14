package com.xu2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xushichao
 * @date 2023/1/2 19:24
 *
 * "{a,b}c{d,e}f"
 * @desc
 */
public class Expand_1087 {

    List<String> res = new ArrayList<>();
    public String[] expand(String s) {
      List<String> list = new ArrayList<>();
      StringBuilder sb;
      for(int i=0; i<s.length(); i++){
          if (s.charAt(i) == '{') {
              sb = new StringBuilder();
              int j= i+1;
              while (j<s.length() && s.charAt(j) != '}') {
                  if(s.charAt(j) != ',') {
                      sb.append(s.charAt(j));
                  }
                  j++;
              }
              list.add(sb.toString());
              i=j;
          } else {
              list.add(s.charAt(i) +"");
          }
      }

        dfs("", 0, list);
        Collections.sort(res); // 按字典顺序返回
        return res.toArray(new String[res.size()]);
    }

    /***
     *
     * @param cur 当前组合字符串
     * @param idx 正在枚举的list的索引
     * @param list
     */
    private void dfs(String cur, int idx, List<String> list) {
        if(idx >= list.size()){
            res.add(cur);
            return;
        }
        //选择第idx个字符串的每个字符
        for(int i=0; i<list.get(idx).length(); i++){
            dfs(cur+list.get(idx).charAt(i), idx+1, list);
        }

    }

    public static void main(String[] args) {
        Expand_1087 expand_1087= new Expand_1087();
        String str = "{a,b}c{d,e}f";
        String[] res = expand_1087.expand(str);
        Arrays.stream(res).forEach(System.out::println);
    }
}
