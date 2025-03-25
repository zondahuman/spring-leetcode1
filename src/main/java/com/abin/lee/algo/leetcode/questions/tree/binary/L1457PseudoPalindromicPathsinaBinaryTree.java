package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 1457. 二叉树中的伪回文路径
 * https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L1457PseudoPalindromicPathsinaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int[] count = new int[10];
    int result = 0 ;
    /**
     * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
     * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        if(root.left == null && root.right == null){
            count[root.val]++;
            int odd = 0;
            for (int n : count) {
                if(n % 2 == 1)
                    odd++;
            }
            if(odd<=1)
                result++;
            count[root.val]--;
            return;
        }
        count[root.val]++;
        traverse(root.left);
        traverse(root.right);
        count[root.val]--;
    }


}
