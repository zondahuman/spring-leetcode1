package com.abin.lee.algo.lc.bst.solution;

import com.abin.lee.algo.lc.bst.dfs.BreadthFirstSearch;
import com.abin.lee.algo.lc.bst.dfs.DepthFirstSearch;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/solutions/382646/er-cha-shu-de-zui-xiao-shen-du-by-leetcode-solutio/
 */
public class BstMinDepth {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    @Test
    public void test(){
        TreeNode treeNode = createTreeNode();
        int depth = minDepth(treeNode);
        System.out.println("depth="+depth);
    }

}
