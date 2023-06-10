package com.xu.leetcode.graph;

import java.util.*;

/**
 * @author xushichao
 * @date 2023/5/25 11:59
 * @desc
 */
public class TopSorted {

    static class Node {
        String val;
        List<Node> children;

        public Node(String val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private Stack<String> stack;
    private Map<Node, Boolean> visited;  //0:未搜索， 1：搜索中， 2：已完成


    public void print(Node root) {
        stack = new Stack<>();
        visited = new HashMap<>();
        dfs(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + ",");
        }

        System.out.println(sb.toString());
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        visited.put(root, true);
        if (root.children != null && root.children.size() > 0) {
            for (Node node : root.children) {
                if (!visited.getOrDefault(node, false)) {
                    dfs(node);
                }
            }
        }
        stack.push(root.val);
    }


    public static void main(String[] args) {
        Node G = new Node("G", null);
        Node F = new Node("F", Arrays.asList(G));
        Node E = new Node("E", Arrays.asList(F));
        Node D = new Node("D", Arrays.asList(E));
        Node B = new Node("B", Arrays.asList(D));
        Node C = new Node("C", Arrays.asList(D));

        Node A = new Node("A", Arrays.asList(B, C));

        TopSorted topSorted = new TopSorted();
        topSorted.print(A);

    }


}
