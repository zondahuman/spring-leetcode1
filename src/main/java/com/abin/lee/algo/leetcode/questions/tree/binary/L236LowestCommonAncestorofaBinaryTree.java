package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/
 */
public class L236LowestCommonAncestorofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p.val , q.val);
    }

    public TreeNode traverse(TreeNode root, int p, int q){
        if(null == root)
            return null;
        if(root.val == p || root.val == q)
            return root;
        TreeNode left = traverse(root.left, p, q);
        TreeNode right = traverse(root.right, p, q);
        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }


}
