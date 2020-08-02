package com.xu.leetcode.contest.c200;

/**
 * Created by sop on 2020/8/2.
 */
public class Test3 {
    public int minSwaps(int[][] grid) {
        //最右边0的个数.  i行的：(n-1-i)个0
        int[] numsZero = new int[grid.length];
        int n = grid.length;
        int k=0;
        for(int[] row : grid){
            numsZero[k++] = countNumsZero(row);
        }

        int pos = 0;
        int res = 0;
        for(int i=0; i<grid.length; i++){
            if(numsZero[i] >= n-1-i ){
                continue;//满足条件，直接跳过
            }

            //往下遍历后面的行，找到“最先"满足条件的，一行行换上去
            int j;
            for(j= i+1; j<n; j++){
                if(numsZero[j] >= n-1-i) {
                    pos = j; //pos为最先满足的行数
                    break;
                }
            }
            if(j==n){
                return -1;//找不到满足条件的行
            }
            //交换 并计算交换次数
            for(int m=pos; m>i; m--){
                swap(numsZero, m-1, m);
            }
            if(pos > i){
                res += (pos - i);
            }
        }
        return res;

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int countNumsZero(int[] row){
        int count =0;
        for(int i=row.length -1; i>=0; i--){
            if(row[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();

    }
}
