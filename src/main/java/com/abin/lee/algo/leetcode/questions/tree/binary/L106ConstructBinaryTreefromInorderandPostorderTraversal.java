package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part2/
 * 通过前序中序，或者后序中序遍历结果可以确定唯一一棵原始二叉树，但是通过前序后序遍历结果无法确定唯一的原始二叉树。
 */
public class L106ConstructBinaryTreefromInorderandPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    Map<Integer, Integer> request = new HashMap<>();
    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            request.put(inorder[i], i);
        }
        return buildBinaryTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildBinaryTree(int[] inorder, int inLow, int inHigh, int[] postorder, int postLow, int postHigh) {
        if(postLow > postHigh)
            return null;
        int maxVal = postorder[postHigh];
        int index = request.get(maxVal);
        int leftSide = index - inLow;
        TreeNode root = new TreeNode(maxVal);
        root.left = buildBinaryTree(inorder, inLow, index-1, postorder, postLow,  postLow+leftSide-1);
        root.right = buildBinaryTree(inorder, index+1, inHigh, postorder, postLow+leftSide, postHigh-1);
        return root;
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
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
        TreeNode result = buildTree(inOrder, postOrder);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
