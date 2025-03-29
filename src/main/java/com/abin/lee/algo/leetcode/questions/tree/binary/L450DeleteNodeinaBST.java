package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode.cn/problems/delete-node-in-a-bst/description/
 * https://labuladong.online/algo/data-structure/bst-part2/
 */
public class L450DeleteNodeinaBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root)
            return null;
        if (root.val == key) {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public static TreeNode getMin(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root;
    }


}
