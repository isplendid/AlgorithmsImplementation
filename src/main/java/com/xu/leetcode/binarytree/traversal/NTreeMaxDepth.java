package com.xu.leetcode.binarytree.traversal;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by sop on 2020/6/6.
 */
public class NTreeMaxDepth {
    public int maxDepth(Node root) {
        Queue<Pair<Node,Integer>> stack = new LinkedList<>();
        if(root!=null){
            stack.add(new Pair(root,1));
        }
        int depth=0;
        while(!stack.isEmpty()){
            Pair<Node,Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();

            depth = Math.max(depth, currentDepth);
            for(Node c:  root.children){
                stack.add(new Pair(c, currentDepth + 1));
            }
        }
        return depth;
    }

    public int maxDepth_Recursive(Node root){
        if(root==null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else {
            List<Integer> heights = new ArrayList<>();
            for(Node item: root.children){
                heights.add(maxDepth_Recursive(item));
            }
            return Collections.max(heights) +1;
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
