package com.xu.leetcode.str;

import java.util.*;

/**
 * @author xushichao
 * @date 2021/9/14 10:30 PM
 * @desc  ，该字符串可以通过删除 s 中的某些字符得到,
 */
public class FindLongestWord_524 {


    //排序+双指针+贪心
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a,b)->{
            if (a.length() != b.length())  {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });
        for(String str: dictionary) {
            if(findDictinary(s, str)){
                return str;
            }
        }
        return "";
    }

    /**
     * a和b
     * @param a
     * @param b
     * @return
     */
    private boolean findDictinary(String a, String b) {
        int i=0, j=0;
        while( i < a.length() &&  j<b.length()){
            if(a.charAt(i) == b.charAt(j)){
                j++;
            }
            i++;
        }
        if(j==b.length()){
            return true;
        }
        return false;
    }


        /***
         * 错误解法，需要保持character的顺序
         * @param s
         * @param dictionary
         * @return
         */
    public String findLongestWord_error(String s, List<String> dictionary) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        //dict排序，优先长度，长度相等则字典序
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String str : dictionary) {
            if (findDict(str, map)) {
                return str;
            }
        }
        return "";
    }

    private boolean findDict(String s, Map<Character, Integer> map) {
        Map<Character, Integer> mapCopy = new HashMap<>(map);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mapCopy.get(c) != null && mapCopy.get(c) != 0) {
                mapCopy.put(c, mapCopy.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dict = new ArrayList<>();
        dict.add("ale");
        dict.add("apple");
        dict.add("monkey");
        dict.add("plea");
        dict.add("abpcplaaa");
        dict.add("abpcllllll");
        dict.add("abccclllpppeeaaaa");
        //"abpcplea"
        //["ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa"]
        FindLongestWord_524 find = new FindLongestWord_524();
        String res = find.findLongestWord(s, dict);
        System.out.println(res);
    }

}
