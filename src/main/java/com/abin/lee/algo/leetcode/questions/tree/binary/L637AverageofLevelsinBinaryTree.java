package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L637AverageofLevelsinBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(null == root)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Double average = 0D;
            double sum = 0;
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                sum +=  node.val;
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
            list.add(1.0 * sum/size);
        }
        return list;
    }

}
