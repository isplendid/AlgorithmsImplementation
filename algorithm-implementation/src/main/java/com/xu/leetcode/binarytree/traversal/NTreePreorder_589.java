package com.xu.leetcode.binarytree.traversal;

import java.util.*;

/**
 * Created by sop on 2020/3/7.
 * N 叉树的前序遍历
 */
public class NTreePreorder_589 {

    /***
     * N叉树先序遍历
     * @param root  只不过前序遍历中对子节点的遍历顺序是 v1, v2, v3，而这里是 v3, v2, v1
     * @return
     */
    public List<Integer> preorder(NNode root) {
        Stack<NNode> stack = new Stack<NNode>();
        LinkedList<Integer> res = new LinkedList();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            List<NNode> childs = root.children;
            if(childs != null){
                Collections.reverse(childs);
                for(NNode c: childs){
                    stack.push(c);
                }
            }
        }
        return res;
    }

    /***
     * N叉树层次遍历 Leetcode-429
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<NNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levels = new ArrayList<>();
            while(size -- > 0){
                NNode cur = queue.poll();
                levels.add(cur.val);
                if(cur.children != null){
                    for(NNode node: cur.children){
                        queue.offer(node);
                    }
                }
            }
            res.add(levels);
        }
        return res;
    }


    /***
     * N叉树后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(NNode root) {
        Stack<NNode> stack = new Stack<NNode>();
        LinkedList<Integer> res = new LinkedList();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.addFirst(root.val);
            List<NNode> childs = root.children;
            if(childs != null){
                for(NNode c: childs){
                    stack.push(c);
                }
            }
        }
        return res;
    }
}
