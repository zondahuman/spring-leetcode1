package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part2/
 */
public class L106ConstructBinaryTreefromInorderandPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {

    }

    TreeNode buildBinaryTree(int[] inorder, int preLow, int preHigh,int[] postorder,int inLow, int inHigh){

        
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
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode result = buildTree(preOrder, inOrder);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
