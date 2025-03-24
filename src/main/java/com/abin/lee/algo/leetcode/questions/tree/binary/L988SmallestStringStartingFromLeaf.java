package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 988. 从叶结点开始的最小字符串
 * https://leetcode.cn/problems/smallest-string-starting-from-leaf/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L988SmallestStringStartingFromLeaf {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    StringBuilder path = new StringBuilder();
    String result = "";

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        if(null == root.left && null == root.right){
            path.append((char)('a' +  root.val));
            path.reverse();

            String str = path.toString();
            if(result.isEmpty() || result.compareTo(str) > 0)
                result = str;

            path.reverse();
            path.deleteCharAt(path.length()-1);
            return;
        }
        path.append((char)('a' +  root.val));
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }



}
