package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
 */
public class L129SumRoottoLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     */
    StringBuilder builder = new StringBuilder();
    int result = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        builder.append(root.val);
        if(root.left == null && root.right == null){
            result += Integer.parseInt(builder.toString());
        }else{
            traverse(root.left);
            traverse(root.right);
            builder.deleteCharAt(builder.length()-1);
        }
    }



}
