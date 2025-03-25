package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L1022SumofRootToLeafBinaryNumbers {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * 示例 1：
     * 输入：root = [1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * 示例 2：
     * 输入：root = [0]
     * 输出：0
     * @param root
     * @return
     */
    int path = 0;
    int result = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        if(root.left== null && root.right == null){
            result += path << 1 | root.val;
            return;
        }

        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        path = path >> 1;
    }


}
