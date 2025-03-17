package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * https://labuladong.online/algo/essential-technique/understand-recursion/
 */
public class L104MaximumDepthofBinaryTree {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public int maxDepth2(TreeNode root) {
        if (null == root)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            length++;
        }
        return length;
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
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        int result = maxDepth(treeNode);
        System.out.println("result=" + result);
        int result2 = maxDepth2(treeNode);
        System.out.println("result2=" + result2);
    }


    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
