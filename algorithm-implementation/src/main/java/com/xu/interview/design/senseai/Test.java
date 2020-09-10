//package com.xu.interview;
//
//import java.util.HashMap;
//import java.util.function.Function;
//import java.util.function.IntConsumer;
//
///**
// * Created by sop on 2020/09/2020/9/7 18:30
// *
// * @Description:
// */
//public class Test {
//
//
//   //Step1
//   //动作， 替换接口（repace()), 倍数;; 参数值
//    public void print(int from, int to){
//        for(int i=from; i<=to; i++){
//            if( (i % 3 == 0) && (i % 5 == 0)  ){
//                System.out.println("AB");
//            } else if( i % 3 == 0){
//                System.out.println("A");
//            }else if( i % 5 == 0){
//                System.out.println("B");
//            }
//            System.out.println(i);
//        }
//    }
//
//
//    //Step2
//
//
//    public void print2(int from, int to){
//
//        Function<Integer, String>  rule1 =
//                (n) -> {
//                    if(n % 3 == 0) {
//                        return "A";
//                    } else {
//                        return String.valueOf(n);
//                    }
//                };
//        Function<Integer, String>  rule2 =
//                (n) -> {
//                    if(n % 5 == 0) {
//                        return "B";
//                    } else {
//                        return String.valueOf(n);
//                    }
//                };
//
//         Function<Integer, String>  rule3 =
//                (n) -> {
//                    if((n % 3 == 0) && (n % 5 == 0)) {
//                        return "AB";
//                    } else {
//                        return String.valueOf(n);
//                    }
//                };
//
//         for(int i=from; i<=to; i++){
//             rule3.andThen(rule2).andThen(rule1).apply(i);
//         }
//
//    }
//
//
//
//    public static void main(String[] args) {
//        Test test = new Test();
//
//    }
//
//}
