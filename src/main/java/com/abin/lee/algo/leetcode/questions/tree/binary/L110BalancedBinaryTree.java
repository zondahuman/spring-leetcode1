package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

/**
 * 110. 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/description/?show=1
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 */
public class L110BalancedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉树，判断它是否是 平衡二叉树
     * 平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。
     *
     * @param root
     * @return
     */


    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        else
            return Math.abs(differ(root.left) - differ(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int differ(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(differ(root.left), differ(root.right));
    }


    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//      1
//    /  \
//   2    3
//  / \   / \
// 4   7  5   6
//      \
//       9
    public TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        boolean result = isBalanced(treeNode);
        System.out.println("result=" + result);
    }

}
