package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L199BinaryTreeRightSideView {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 示例 1：
     * 输入：root = [1,2,3,null,5,null,4]
     * 输出：[1,3,4]
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode temp = queue.poll();
                if(size-1==i) {
                    list.add(temp.val);
                }
                if(null != temp.left)
                    queue.offer(temp.left);
                if(null != temp.right)
                    queue.offer(temp.right);
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
//      \       \
//       9       8
    public TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
//        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//        root.right.right.right = new TreeNode(8);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        List<Integer> result = rightSideView(treeNode);
        System.out.println("result=" + JsonUtil.toJson(result));
    }
    

}
