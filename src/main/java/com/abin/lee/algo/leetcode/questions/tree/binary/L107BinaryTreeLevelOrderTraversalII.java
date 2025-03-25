package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L107BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        if(null == root)
            return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left)
                    queue.offer(node.left);
                if(null != node.right)
                    queue.offer(node.right);
            }
            resultList.addFirst(list);
        }
        return  resultList;
    }


    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//      1
//    /   \
//   2      8
//  / \    /  \
// 4   5  7     9
//      \
//       6
    public TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = createTreeNode();
        List<List<Integer>>  result = levelOrderBottom(root);
        System.out.println("result=" + JsonUtil.toJson(result));
    }
    
    
    
    
}
