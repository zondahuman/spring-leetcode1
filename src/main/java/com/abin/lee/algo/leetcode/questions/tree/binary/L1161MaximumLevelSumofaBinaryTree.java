package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L1161MaximumLevelSumofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if(null == root)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
            if(levelSum > maxSum){
                maxSum = levelSum;
                result = depth;
            }
            depth++;

        }
        return result;
    }



}
