package com.xu.leetcode.binarytree.traversal;

import java.util.List;

/**
 * Created by sop on 2020/3/7.
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
