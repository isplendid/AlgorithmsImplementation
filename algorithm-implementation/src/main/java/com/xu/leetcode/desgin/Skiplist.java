package com.xu.leetcode.desgin;

import java.util.Random;

/**
 * @author xushichao
 * @date 2022/11/13 15:13
 * @desc
 * 参考视频讲解：https://www.youtube.com/watch?v=m6m0pnsOzN4&list=PLvOO0btloRnvVQXtKOi33mdJS9-5khJM3&index=3
 * 参考github资料：https://github.com/wangshusen/AdvancedAlgorithms
 *
 * 最好是logN层，查找和插入的时间复杂度都是logN
 */
public class Skiplist {

    private int level = 10;

    class SkipNode{
        int val;
        SkipNode[] next = new SkipNode[level];
        SkipNode(int _val){
            this.val = _val;
        }
    }

    public Skiplist() {


    }
    Random random = new Random();
    SkipNode sentinel = new SkipNode(-1);


    public boolean search(int target) {
         SkipNode[] startNodes = new SkipNode[level];
         find(target, startNodes);
         //找到的前一个节点
         return startNodes[0].next[0] !=null &&  startNodes[0].next[0].val == target;
    }

    public void add(int num) {
       SkipNode[] startNodes = new SkipNode[level];
       find(num, startNodes);
       SkipNode newNode = new SkipNode(num);
       //从低level到高level, 按概率增加
       for(int i=0; i<level; i++){
           newNode.next[i] = startNodes[i].next[i];
           startNodes[i].next[i] = newNode;
           //随机P=0.5增加与否
           if(random.nextInt(2) == 0) {
               break;
           }
       }
    }

    public boolean erase(int num) {
        SkipNode[] startNodes = new SkipNode[level];
        find(num, startNodes);
        SkipNode node = startNodes[0].next[0];
        if(node==null || node.val != num){
            return false;
        }
        for(int i=0; i<level && startNodes[i].next[i] == node; i++){
            startNodes[i].next[i] = startNodes[i].next[i].next[i];
        }
        return true;
    }

    /***
     * startNodes为每层的区间起始节点
     * @param target
     * @param startNodes
     */
    private void find(int target, SkipNode[] startNodes) {
        SkipNode cur = sentinel;
        for(int i=level-1; i>=0; i--){
            while(cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
            startNodes[i] = cur;
        }
    }


    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        boolean res1 = skiplist.search(0); // return False
        skiplist.add(4);
        boolean res2= skiplist.search(1); // return True
        skiplist.erase(0);  // return False, 0 is not in skiplist.
        skiplist.erase(1);  // return True
        boolean res3 = skiplist.search(1); // return False, 1 has already been erased.

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }




}
