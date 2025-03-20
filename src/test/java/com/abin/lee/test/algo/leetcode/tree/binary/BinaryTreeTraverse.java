package com.abin.lee.test.algo.leetcode.tree.binary;

import com.abin.lee.algo.leetcode.questions.tree.binary.L543DiameterofBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraverse {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public List preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        List list = new LinkedList();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                List.add(root.val);
                if(root.right!=null)
                    stack.push(root.right);
                root = root.left;
            }else {
                root = stack.pop();
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List ineorder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        List list = new LinkedList();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }


    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List postorder(TreeNode root){
        TreeNode node = new TreeNode();
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new LinkedList();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                //头插法
//                list.addFirst(root.val);
                list.add(root.val);
                if(root.left!=null)
                    stack.push(root.left);
                //优先访问右子树
                root = root.right;
            }else {
                root = stack.pop();
            }
        }
        return list;
    }


}
