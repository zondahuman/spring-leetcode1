package com.abin.lee.algo.lc.bst.dfs;

import org.junit.Test;

public class DepthFirstSearch {


    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//     1
//    / \
//   2   3
//  /   / \
// 4   5   6
    public TreeNode createTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test(){
        TreeNode treeNode = createTreeNode();
        traverse(treeNode);
    }
    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//     1
//    / \
//   2   3
//  /   / \
// 4   5   6
    public void traverse(TreeNode root){
        if(null == root){
            System.out.println("null == root");
            return;
        }
        System.out.println("traverse---before");
        traverse(root.left);
        System.out.println("traverse---middle");
        traverse(root.right);
        System.out.println("traverse---after");
    }



    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}
