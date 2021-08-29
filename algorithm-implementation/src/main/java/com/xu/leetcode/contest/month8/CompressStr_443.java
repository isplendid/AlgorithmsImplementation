package com.xu.leetcode.contest.month8;

/**
 * @author xushichao
 * @date 2021/8/21 6:48 PM
 * @desc
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 */
public class CompressStr_443 {

    public int compress(char[] chars) {
        int read=0, write=0;
        while(read < chars.length) {
            //连续读了多少个
            int readStart = read;
            //寻找不同的下一个
            while(read +1 < chars.length && chars[read +1] == chars[read]) { //倒数第二个与倒数第一个相等
                read++;
            }

            chars[write++] = chars[readStart];

            //数量大于1时记录数量
            if(readStart != read) {
                int count = read - readStart + 1;
                int writeStart = write;
                //先写的是个位数
                while(count != 0){
                    chars[write++] = (char) (count % 10 + '0');
                    count = count /10;
                }
                //需要按照高位到低位逆置位
                reverseString(chars, writeStart, write -1);
            }

            //读指针移动到下一个字符位置
            read++;
        }
        return write;
    }

    public void reverseString(char[] s, int l, int r) {
        while(l<r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

//    public int compress(char[] chars) {
//      int cnt=0;
//      int sum =0;
//      int idx =0;
//      for(int i=0; i<chars.length-1; i++){
//          //处理导出第二个及之前的字符
//          if(chars[i] == chars[i+1]) {
//              cnt++;
//          } else { //开启新字符,当前字符和下一个不一样
//              cnt++;
//              if(cnt ==1 ) {
//                  sum += 1;
//                  chars[idx++] = chars[i];
//              } else {
//                  sum += 1+ calLength(cnt);
//              }
//              cnt=0;
//          }
//          //处理最后一个字符
//          if(i==chars.length -2) {
//              if(chars[i] == chars[i+1]){
//                  cnt ++;
//                  sum = sum + (cnt == 1 ? 1: 1+ calLength(cnt));
//              } else {
//                  sum = sum +1;
//              }
//          }
//      }
//      return sum;
//    }
//
//    private int calLength(int n){
//        int len =0;
//        while(n/10 != 0) {
//            n = n/10;
//            len++;
//        }
//        return len+1;
//    }

    public static void main(String[] args) {
        CompressStr_443 cm = new CompressStr_443();
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int res = cm.compress(chars);
        System.out.println(res);


        char[] chars2 = new char[]{'a','a','b','b','c','c','c'};
        int res2 = cm.compress(chars2);
        System.out.println(res2);
    }
}
