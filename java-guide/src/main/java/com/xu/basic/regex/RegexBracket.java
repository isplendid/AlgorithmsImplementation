package com.xu.basic.regex;

import org.joda.time.DateTime;

/**
 * @author xushichao
 * @date 2020/10/25 8:36 PM
 * @desc
 */
public class RegexBracket {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        dateTime.withTimeAtStartOfDay();
        String DATE_FORMAT2 = "yyyy-MM-dd HH:mm:ss";
        //System.out.println(dateTime.withTimeAtStartOfDay().toString(DATE_FORMAT2));
        System.out.println(dateTime.plusDays(1).withTimeAtStartOfDay().toString(DATE_FORMAT2));
    }

    public static void main1(String[] args) {
        String chars = "[\\[\\]【】]";
        String test = "[牛栏山]陈酿白酒";
        String test1 ="[【红牛]】";
        String res = test1.replaceAll(chars,"");
        System.out.println(res);
    }
}
