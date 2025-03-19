package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/description/?show=1
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 */
public class L101SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 
     * 如果同时满足下面的条件，两个树互为镜像：
     * 它们的两个根结点具有相同的值
     * 每个树的右子树都与另一个树的左子树镜像对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        boolean flag = isSameTree(root.left, root.right);
        return flag;
    }
    
    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || null == right)
            return false;
        if(left.val != right.val)
            return false;
        return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }


    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//      1
//    /  \
//   2    3
//  / \   / \
// 4   7  5   6
//      \
//       9
    public TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        boolean result = isSymmetric(treeNode);
        System.out.println("result=" + result);
    }



}
