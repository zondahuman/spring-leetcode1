package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 222. 完全二叉树的节点个数
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 * https://labuladong.online/algo/data-structure/count-complete-tree-nodes/
 */
public class L222CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int hl = 0, hr = 0;
        while(null != left){
            hl++;
            left = left.left;
        }
        while(null != right){
            hr++;
            right = right.right;
        }
        int result = 0;
        if(hl == hr){
            return (int)Math.pow(2, hl)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
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
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        return root;
    }


    @Test
    public void test() {
        TreeNode treeNode = createTreeNode();
        int result = countNodes(treeNode);
        System.out.println("result=" + JsonUtil.toJson(result));
    }   




}
