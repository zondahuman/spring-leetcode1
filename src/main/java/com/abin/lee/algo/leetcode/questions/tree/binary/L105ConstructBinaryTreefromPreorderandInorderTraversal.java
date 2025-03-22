package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part2/
 * 通过前序中序，或者后序中序遍历结果可以确定唯一一棵原始二叉树，但是通过前序后序遍历结果无法确定唯一的原始二叉树。
 */
public class L105ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，
     * 请构造二叉树并返回其根节点。
     * 示例 1:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     *
     * 示例 2:
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> requst = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <inorder.length ; i++) {
            requst.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length);
    }

    TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if(preLow>preHigh)
            return null;
        int maxVal = preorder[preLow];
        int index = requst.get(maxVal);
        int leftSize = index - inLow ;
        TreeNode root = new TreeNode(maxVal);
        root.left = build(preorder, preLow+1, preLow+leftSize, inorder, inLow, index-1);
        root.right = build(preorder, preLow+leftSize+1, preHigh, inorder, index+1, inHigh);
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
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode result = buildTree(preOrder, inOrder);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
