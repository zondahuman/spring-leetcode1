package com.abin.lee.algo.lc.bst.mul;


import java.util.List;

public class MultiTreeNode {


    static class MultiNode {
        int val;
        List<MultiNode> children;

        MultiNode(int val) {
            this.val = val;
        }
    }


    void traverse(MultiNode root){
        if(null == root){
            return;
        }
        for(MultiNode multiNode : root.children){
            traverse(multiNode);
        }
    }






}

