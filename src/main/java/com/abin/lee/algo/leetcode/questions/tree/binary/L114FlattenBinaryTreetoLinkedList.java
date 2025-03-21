package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 * https://labuladong.online/algo/data-structure/binary-tree-part1/
 */
public class L114FlattenBinaryTreetoLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root
     */
    TreeNode dummy = new TreeNode(-1);
    TreeNode pest = dummy;

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while(!deque.isEmpty() || null != node ){
            while(null != node){
                list.add(node);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i <size ; i++) {
            TreeNode curr = list.get(i-1), next = list.get(i);
            curr.left = null;
            curr.right = next;
        }
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
        System.out.println("treeNode-before=" + JsonUtil.toJson(treeNode));
        flatten(treeNode);
        System.out.println("treeNode-after="  + JsonUtil.toJson(treeNode));
//        int result2 = maxDepth2(treeNode);
//        System.out.println("result2=" + result2);
    }



}
