package com.xu.leetcode.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author xushichao
 * @date 2021/9/5 10:27 PM
 * @desc
 */
public class FirstUniqChar_Offer50 {
    public char firstUniqChar(String s) {
        if(s.length()==0){
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for(int i=0; i<s.length();i++) {
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }
}
