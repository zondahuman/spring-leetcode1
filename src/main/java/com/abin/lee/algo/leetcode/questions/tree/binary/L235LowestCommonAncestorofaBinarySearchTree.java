package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/
 */
public class L235LowestCommonAncestorofaBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return traverse(root, val1, val2);
    }

    TreeNode traverse(TreeNode root, int val1, int val2){
        if(null == root)
            return null;
        if(root.val > val2)
            return traverse(root.left, val1, val2);
        if(root.val < val1)
            return traverse(root.right, val1, val2);
        return root;
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
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode result = lowestCommonAncestor(root, treeNode1, treeNode2);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    
    
    
    
}
