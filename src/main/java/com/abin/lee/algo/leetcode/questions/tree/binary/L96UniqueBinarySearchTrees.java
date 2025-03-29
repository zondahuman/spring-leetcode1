package com.abin.lee.algo.leetcode.questions.tree.binary;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 * https://labuladong.online/algo/data-structure/bst-part3/
 */
public class L96UniqueBinarySearchTrees {

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * 本题目会超时，没有通过
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return count(1, n);
    }

    public int count(int low, int high){
        if(low > high)
            return 1;
        int result = 0;
        for (int i = low; i <=high ; i++) {
            // i 的值作为根节点 root
            int left = count(low, i-1);
            int right = count(i+1, high);
            result += left * right ;
        }
        return result;
    }
}
