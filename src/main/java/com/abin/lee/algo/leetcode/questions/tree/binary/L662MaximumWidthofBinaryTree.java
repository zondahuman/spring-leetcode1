package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L662MaximumWidthofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static class Pair{
        TreeNode node;
        int id;
        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    /**
     * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
     * 树的 最大宽度 是所有层中最大的 宽度 。
     * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
     * 题目数据保证答案将会在  32 位 带符号整数范围内。
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if(null == root)
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int maxWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0, end = 0 ;
            for (int i = 0; i <size ; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int curId = pair.id;
               if(i == 0)
                   start = curId;
               if(i == size -1)
                   end = curId;
               if(null != node.left)
                   queue.offer(new Pair(node.left, 2*curId));
               if(null != node.right)
                   queue.offer(new Pair(node.right, 2*curId+1));
            }
            maxWidth = Math.max(maxWidth, end-start+1);
        }
        return maxWidth;
    }

}
