package com.abin.lee.algo.lc.bst.dfs;

import com.abin.lee.algo.lc.bst.TreeNode;
import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class BreadthFirstSearch {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 你可以这样构建一棵二叉树：
    // 构建出来的二叉树是这样的：
//     1
//    / \
//   2   3
//  /   / \
// 4   5   6
    public TreeNode createTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    public void levelOrderTraverse(TreeNode root){
        if(null == root){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll() ;
            System.out.println("val="+cur.val);
            if(cur.left != null){
                queue.offer(cur.left) ;
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    @Test
    public void test1(){
        TreeNode treeNode = createTreeNode();
        this.levelOrderTraverse(treeNode);
    }



}
