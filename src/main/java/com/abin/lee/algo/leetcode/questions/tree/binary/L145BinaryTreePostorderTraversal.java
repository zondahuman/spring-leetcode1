package com.abin.lee.algo.leetcode.questions.tree.binary;

import org.junit.Test;

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
        TreeNode prev = null;
        while(!deque.isEmpty() || null != node){
            while(null != node){
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            if(node.right == null || node.right == prev){
                list.add(node.val);
                prev = node;
                node = null;
            }else{
                deque.push(node);
                node = node.right;
            }
        }
        return list;
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
//        List<Integer> result = postorderTraversal(treeNode);
//        System.out.println("result=" + result);
//        List<Integer> result2 = postorderTraversal2(treeNode);
//        System.out.println("result2=" + result2);
        List<Integer> result3 = postorderTraversal3(treeNode);
        System.out.println("result3=" + result3);
    }

}
