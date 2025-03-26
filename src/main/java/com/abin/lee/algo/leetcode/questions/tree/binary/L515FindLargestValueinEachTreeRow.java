package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L515FindLargestValueinEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(maxValue, node.val);
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
            list.add(maxValue);
        }
        return list;
    }
    
    
    
    
}
