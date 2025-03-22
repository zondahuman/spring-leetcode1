package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part2/
 * 通过前序中序，或者后序中序遍历结果可以确定唯一一棵原始二叉树，但是通过前序后序遍历结果无法确定唯一的原始二叉树。
 */
public class L889ConstructBinaryTreefromPreorderandPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
     * <p>
     * 如果存在多个答案，您可以返回其中 任何 一个。
     * <p>
     * 示例 1：
     * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     * <p>
     * 示例 2:
     * 输入: preorder = [1], postorder = [1]
     * 输出: [1]
     *
     * @param preorder
     * @param postorder
     * @return
     */
    Map<Integer, Integer> request = new HashMap<>();


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            request.put(postorder[i], i);
        }
        return buildBinaryTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildBinaryTree(int[] preorder, int preLow, int preHigh, int[] postorder, int postLow, int postHigh) {
        if (preLow > preHigh)
            return null;
        if (preLow == preHigh)
            return new TreeNode(preorder[preLow]);
        int maxVal = preorder[preLow];
        int leftMaxVal = preorder[preLow + 1];
        int index = request.get(leftMaxVal);
        int leftSide = index - postLow + 1;

        TreeNode root = new TreeNode(maxVal);
        root.left = buildBinaryTree(preorder, preLow + 1, preLow + leftSide, postorder, postLow, index);
        root.right = buildBinaryTree(preorder, preLow + leftSide + 1, preHigh, postorder, index+1, postHigh-1);
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
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postOrder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode result = constructFromPrePost(preorder, postOrder);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
