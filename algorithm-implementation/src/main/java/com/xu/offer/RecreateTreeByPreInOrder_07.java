package com.xu.offer;

import com.xu.offer.base.TreeNode;

import java.util.*;

/**
 * Created by sop on 2020/09/2020/9/1 15:21
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @Description:
 */
public class RecreateTreeByPreInOrder_07 {

    private Map<Integer, Integer> map = new HashMap<>(); //存储中序遍历的每个元素及其对应的下标

    /***
     * 确定三个节点的关系 ：
     * 1.树的根节点
     * 2.左子树根节点
     * 3.右子树根节点（即前序遍历中左（右）子树的首个元素）
     *
     *   递归出口：
     * 1）判断前序遍历的下标范围的开始和结束，若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
     * 2）若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
     * 3）若开始小于结束，则当前的二叉树中有多个节点
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /***
     *
     * @param preorder
     * @param pl  preorder start
     * @param pr  preorder end
     * @param inorder
     * @param il
     * @param ir
     * @return
     */
    public TreeNode createTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        if (pl == pr) {
            return root;
        }
        int rootIndex = map.get(rootVal);
        int leftNodes = rootIndex - il;
        int rightNodes = ir - rootIndex;
        TreeNode leftSubTree = createTree(preorder, pl + 1, pl + leftNodes, inorder, il, rootIndex - 1);
        TreeNode rightSubTree = createTree(preorder, pr - rightNodes + 1, pr, inorder, rootIndex + 1, ir);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};//{3, 9, 20, 15, 7};
        int[] inorder = new int[]{3,2,1};//{9, 3, 15, 20, 7};
        RecreateTreeByPreInOrder_07 cre = new RecreateTreeByPreInOrder_07();
        TreeNode root = cre.buildTree(preorder, inorder);

        System.out.println(cre.levelPrintTree(root));
    }

    public List<List<Integer>> levelPrintTree(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
