package com.xu.interview;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sop on 2020/09/2020/9/1 19:36
 *   实现一个 BufferedWordReader 类，实现每次调用成员函数 `string readWord()` 能从纯英文文件 novels.txt 里依次返回 1 个单词，
 *   尽可能的完善、高效（少占用内存，考虑 novels.txt 可能会非常大）。
 * # 可以在自己顺手的 IDE 上完成编码，并构造用例，给出示例输出
 * @Description:
 */
public class BufferedWordReader {

    private static long wordCnt = 0;
    private static long lineCnt =0;
    private static long nextLineCnt = 1;
    private static List<String> curWords;

    public static String readWord() throws IOException {
        String word = null;
        wordCnt ++;
        if(wordCnt < nextLineCnt){
            long idx = curWords.size() - (nextLineCnt - wordCnt);
            return curWords.get(Integer.valueOf(String.valueOf(idx)));
        }

        try (InputStream fis = new FileInputStream("novels.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
        ) {
            List<String> list = br.lines().skip(lineCnt).limit(1).collect(Collectors.toList());
            lineCnt ++;
            String[] words = list.get(0).split("\\s+");
            curWords = Arrays.asList(words);
            nextLineCnt += curWords.size();
            word = words[0];
        }
        return word;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readWord());
        System.out.println(readWord());
        System.out.println(readWord());
        System.out.println(readWord());
        System.out.println(readWord());
    }
}
