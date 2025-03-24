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

    /**
     * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
     * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
     * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
     * 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
     * 节点的叶节点是没有子节点的节点。
     */
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
