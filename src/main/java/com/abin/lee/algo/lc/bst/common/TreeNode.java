package com.abin.lee.algo.lc.bst.common;

import lombok.Data;

@Data
public class TreeNode {
    int val ;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//     1
//    / \
//   2   3
//  /   / \
// 4   5   6
    public static TreeNode createTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }




}
