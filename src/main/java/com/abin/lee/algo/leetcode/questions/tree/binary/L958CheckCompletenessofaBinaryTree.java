package com.abin.lee.algo.leetcode.questions.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 958. 二叉树的完全性检验
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
 * https://labuladong.online/algo/problem-set/binary-tree-level-i/
 */
public class L958CheckCompletenessofaBinaryTree {
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
    public boolean isCompleteTree(TreeNode root) {
        if(null == root)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                if(null == node){
                    flag = true;
                }else{
                    if(flag)
                        return false;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

            }
        }
        return true;
    }


}
