package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. 奇偶树
 * https://leetcode.cn/problems/even-odd-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/#slug_even-odd-tree
 */
public class L1609EvenOddTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
     * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
     * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
     * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean even = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                if(even){
                    if(prev >= node.val || node.val % 2 == 0){
                        return false;
                    }
                }else{
                    if(prev <= node.val || node.val % 2 == 1){
                        return false;
                    }
                }
                prev = node.val ;
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
            even = !even ;
        }
        return true;
    }


}
