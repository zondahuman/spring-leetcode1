package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
 *
 */
public class L538ConvertBSTtoGreaterTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * 提醒一下，二叉搜索树满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int result = 0;
    void traverse(TreeNode root){
        if(null == root)
            return;
        traverse(root.right);
        result += root.val ;
        root.val = result;
        traverse(root.left);
    }


}
