package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 1038. 从二叉搜索树到更大和树
 * https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/description/
 */
public class L1038BinarySearchTreetoGreaterSumTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
     * 提醒一下， 二叉搜索树 满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    int result = 0;
    void traverse(TreeNode root){
        if(null == root)
            return;
        traverse(root.right);
        result += root.val ;
        root.val = result ;
        traverse(root.left);
    }




}
