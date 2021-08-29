package com.xu2021.dp;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/3/31 7:44 AM
 * @desc
 */
public class CoinChange_322 {
//    public static int coinChange(int[] coins, int amount) {
//        if (coins.length == 0) {
//            return 0;
//        }
//        int rest = amount;
//        int count = 0;
//        Arrays.sort(coins);
//        for (int i = coins.length - 1; i >= 0; i--) {
//            int curCnt = rest / coins[i]; //计算当前面值最多能用多少个
//            rest -= curCnt * coins[i]; //计算使用完当前面值后的余额
//            count += curCnt;
//
//            if (rest == 0) {
//                return count;
//            }
//        }
//        return -1;
//    }

    int res = Integer.MAX_VALUE;
    public  int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        findWay(coins,amount,0);
        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }
        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }


    public static void main(String[] args) {
        CoinChange_322 coin = new CoinChange_322();
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        int res = coin.coinChange(coins, amount);
        System.out.println(res);


    }
}