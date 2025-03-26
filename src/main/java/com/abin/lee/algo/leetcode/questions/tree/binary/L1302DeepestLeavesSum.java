package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode.cn/problems/deepest-leaves-sum/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/#slug_deepest-leaves-sum
 */
public class L1302DeepestLeavesSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        if(null == root)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
        }
        return sum;
    }


}
