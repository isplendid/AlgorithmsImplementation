package com.xu2025;

import java.util.*;

public class Main1 {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//


    private static String sort(String str) {
        List<String> smallWords = new ArrayList<>();
        List<String> bigWords = new ArrayList<>();
        int start = -1;
        for(int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLetter(c) ) {
               if(start == -1) {
                   start = i;
               }
               if(i == str.length() -1 ) {
                   String word =  str.substring(start) ;
                   if(str.charAt(start) >= 'A' && str.charAt(start) <= 'Z') {
                       bigWords.add(word);
                   } else {
                       smallWords.add(word);
                   }
               }
            } else {
                if(start != -1) {
                    String word = i == str.length() -1 ? str.substring(start) : str.substring(start, i);
                    if(str.charAt(start) >= 'A' && str.charAt(start) <= 'Z') {
                        bigWords.add(word);
                    } else {
                        smallWords.add(word);
                    }
                }
                start = -1;
            }
        }



        Collections.sort(smallWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
            }
        });

        Collections.sort(bigWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });

//
//        System.out.println(smallWords);
//        System.out.println(bigWords);

        // words sort;
        String res = joinCollect(smallWords) +" " + joinCollect(bigWords);
        return res;
    }

    private static String joinCollect(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< words.size(); i++) {
            sb.append(words.get(i));
            if(i != words.size()-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String raw = "Land of the Old Thirteen! Massachusetts land! land of Vermont and Connecticut X";
        String expected = "and land land of of the Vermont Thirteen Old Massachusetts Land Connecticut";
        Main1 main1 =new Main1();
        String res = main1.sort(raw);
        System.out.println(res);

//        Scanner in = new Scanner(System.in);
//
//       while( in.hasNext()) {
//            in.next();
//        }


    }
}
