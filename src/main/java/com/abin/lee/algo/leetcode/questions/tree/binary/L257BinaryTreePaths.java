package com.abin.lee.algo.leetcode.questions.tree.binary;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/description/
 * https://labuladong.online/algo/problem-set/binary-tree-traverse-i/
 */
public class L257BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        traverse(root, "", paths);
        return paths;
    }

    void traverse(TreeNode root, String path, List<String> paths){
        if(null != root){
            StringBuffer pathSb = new StringBuffer(path);
            pathSb.append(root.val);
            if(root.left == null && null == root.right){
                paths.add(pathSb.toString());
            }else{
                pathSb.append("->");
                traverse(root.left, pathSb.toString(), paths);
                traverse(root.right, pathSb.toString(), paths);
            }
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
        root.right.right.right = new TreeNode(6);
        return root;
    }


    @Test
    public void test() {
        TreeNode root = createTreeNode();
//        TreeNode treeNode1 = new TreeNode(4);
//        TreeNode treeNode2 = new TreeNode(9);
        List<String> result = binaryTreePaths(root);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
