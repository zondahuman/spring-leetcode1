package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
 * https://labuladong.online/algo/data-structure/bst-part2/
 */
public class L701InsertintoaBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(null == root)
            return new TreeNode(val);
        if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        if(root.val < val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }

}
