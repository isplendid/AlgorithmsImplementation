package com.xu;

/**
 * @author xushichao
 * @date 2022/2/25 3:11 PM
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        Byte val = -100;
        Double val2 = 2.1D;

        //System.out.println(convertByteToInt(val));
        System.out.println(convertByteToInt(val2));




    }

    private static Object convertByteToInt(Object hiveValue) {
        if(hiveValue instanceof  Byte) {
            System.out.println("is Byte");
            return Integer.parseInt(hiveValue.toString()) ;
        }
        System.out.println("raw val");
       return hiveValue;
    }
    }

