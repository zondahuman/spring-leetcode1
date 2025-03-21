package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part2/
 */
public class L654MaximumBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树 。
     *
     * 题目给出的最大二叉树的性质是：
     * 1.所有父节点>其子（孙）节点
     * 2.树的顺序与数组相同（数组中a位于b的左边，那在树中a要么是b的左子节点，要么b是a的右子节点）
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length-1);
    }

    public TreeNode traverse(int[] nums, int low, int high){
        if(low > high)
            return null;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = low; i <=high ; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = traverse(nums, low, index-1);
        root.right = traverse(nums, index+1, high);
        return root;
    }



}
