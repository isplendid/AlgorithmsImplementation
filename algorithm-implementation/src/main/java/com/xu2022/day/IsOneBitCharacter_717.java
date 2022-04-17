package com.xu2022.day;

/**
 * @author xushichao
 * @date 2022/2/20 10:56 PM
 * @desc
 */
public class IsOneBitCharacter_717 {
    public static boolean isOneBitCharacter(int[] bits) {

        for(int i=0; i<bits.length;){
            if(bits[i] == 1) {
               if(i== bits.length-1){
                   return false;
               } else {
                   i+=2;
               }
            } else if(bits[i]== 0) {
                if( i==bits.length-1) {
                    return true;
                } else {
                    i+=1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int[] bits = new int[]{1,1};
        boolean res =  isOneBitCharacter(bits);
        System.out.println(res);

    }
}
