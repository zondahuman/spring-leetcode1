package com.abin.lee.algo.leetcode.questions.list;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/
 * 373. Find K Pairs with Smallest Sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/#slug_find-k-pairs-with-smallest-sums
 */
public class FindKPairswithSmallestSums373 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 373. 查找和最小的 K 对数字 | 力扣 | LeetCode |  🟠
     * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
     * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) ->{
            return ((a[0]+a[1]) - (b[0]+b[1]));
        });
        for (int i = 0; i <nums1.length ; i++) {
            priorityQueue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> list = new ArrayList<>();
        while(!priorityQueue.isEmpty() && k > 0){

        }
        
    }




}
