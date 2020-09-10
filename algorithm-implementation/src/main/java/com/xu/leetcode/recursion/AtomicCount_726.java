//package com.xu.leetcode.recursion;
//
//import org.junit.Assert;
//
///**
// * Created by sop on 2020/5/25.
// * 原子的个数
// *
// */
//public class AtomicCount_726 {
//  private  int i = 0;
//
//    public String countOfAtoms(String formula) {
//
//    }
//
//    private String getName(char[] f){
//       StringBuilder name = new StringBuilder(f[i++]);
//       while(i < f.length && 'a' <= f[i] && f[i] <= 'z'){
//           name.append(f[i++]);
//       }
//        return name.toString();
//
//    }
//
//    private int getCount(char[] f){
//
//    }
//
//    public static void main(String[] args) {
//        AtomicCount_726 at = new AtomicCount_726();
//        String test1="H2O";
//        String test2 = "K4(ON(SO3)2)2";  //    原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
//        Assert.assertEquals(at.countOfAtoms(test1), "H2O");
//        Assert.assertEquals(at.countOfAtoms(test2), "K4N2O14S4");
//
//    }
//
//
//}
