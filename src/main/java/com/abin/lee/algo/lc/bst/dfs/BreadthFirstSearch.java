package com.abin.lee.algo.lc.bst.dfs;

import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class BreadthFirstSearch {

   static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
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

    //队列实现广度遍历
    @Test
    public void test1(){
        TreeNode treeNode = createTreeNode();
        this.levelOrderTraverse(treeNode);
    }


    //比方说让你收集每一层的节点，或者计算二叉树的最小深度等等。
    public void levelOrderTraverse2(TreeNode root){
        if(null == root){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int sz = queue.size() ;
            for (int i = 0; i <sz ; i++) {
                TreeNode cur = queue.poll() ;
                System.out.println("i="+i+",val="+cur.val);
                if(null != cur.left){
                    queue.offer(cur.left);
                }
                if(null != cur.right){
                    queue.offer(cur.right);
                }
            }
            depth++ ;
        }
    }

    //队列实现广度遍历，
    @Test
    public void test2(){
        TreeNode treeNode = createTreeNode();
        this.levelOrderTraverse2(treeNode);
    }


}
