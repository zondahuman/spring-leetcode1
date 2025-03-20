package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/?show=1
 * https://labuladong.online/algo/essential-technique/binary-tree-summary/
 */
public class L145BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    List<Integer> list2 = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(null == root)
            return list2;
        traverse(root);
        return list2;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        traverse(root.left);
        traverse(root.right);
        list2.add(root.val);
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Deque<TreeNode> deque = new LinkedList<>() ;
        TreeNode node = root;
        while(!deque.isEmpty() || null != node){
            while(null != node){
                deque.push(node);
                node = node.left;
            }
            TreeNode temp = deque.pop();


        }
        return null;
    }



}
