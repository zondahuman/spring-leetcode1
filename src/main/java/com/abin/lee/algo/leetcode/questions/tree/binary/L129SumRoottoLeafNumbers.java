package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
 */
public class L129SumRoottoLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     */
    StringBuilder builder = new StringBuilder();
    int result = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if(null == root)
            return;
        builder.append(root.val);
        if(root.left == null && root.right == null){
            result += Integer.parseInt(builder.toString());
        }
        traverse(root.left);
        traverse(root.right);
        builder.deleteCharAt(builder.length()-1);
    }


    public int sumNumbers2(TreeNode root) {
        return traverseDfs(root, 0);
    }

    int  traverseDfs(TreeNode root, int prevSum){
        if(null == root)
            return 0;
        int sum = prevSum*10 + root.val;
        if(null == root.left && root.right == null){
            return sum;
        }else{
            return traverseDfs(root.left, sum) + traverseDfs(root.right, sum);
        }
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
        int result = sumNumbers(treeNode);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
