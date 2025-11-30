package com.xu2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortWord {

    private static String sort(String sentence) {
        String noPunctuation = sentence.replaceAll("[^a-zA-Z ]", "");

        // 2. 分割字符串为单词数组
        List<String> words = Arrays.asList(noPunctuation.split("\\s+"));


        // 3. 分类单词
        List<String> lowerCaseWords = words.stream()
                .filter(word -> Character.isLowerCase(word.charAt(0)))
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.charAt(0) - o2.charAt(0);
                    }
                }) // 默认字典顺序
                .collect(Collectors.toList());

        List<String> upperCaseWords = words.stream()
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.charAt(0) - o1.charAt(0);
                    }
                }) // 字典逆序
                .collect(Collectors.toList());

        // 4. 合并结果：先添加小写首字母的单词，再添加大写首字母的单词
        lowerCaseWords.addAll(upperCaseWords);
        // 5. 将处理好的单词合并为句子
        return String.join(" ", lowerCaseWords);
    }


    public static void main(String[] args) {
        String raw = "Land of the Old Thirteen! Massachusetts land! land of Vermont and Connecticut";
        String res = sort(raw);
        System.out.println(res);
    }

}
