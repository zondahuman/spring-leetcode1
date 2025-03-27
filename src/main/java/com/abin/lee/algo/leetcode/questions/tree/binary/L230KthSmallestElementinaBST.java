package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 230. 二叉搜索树中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 */
public class L230KthSmallestElementinaBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    int rank = 0 ;
    int result = 0;
    void traverse(TreeNode root, int k){
        if(null == root)
            return;
        traverse(root.left, k);
        rank++;
        if(rank == k){
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }


}
