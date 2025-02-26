package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

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
            return (a[0]+a[1]) - (b[0]+b[1]);
        });
        for (int i = 0; i <nums1.length ; i++) {
            priorityQueue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> list = new ArrayList<>();
        while(!priorityQueue.isEmpty() && k > 0){
            int[] cur = priorityQueue.poll();
            k--;
            int next = cur[2]+1;
            if(next < nums2.length){
                priorityQueue.offer(new int[]{cur[0], nums2[next],next});
            }
            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            list.add(pair);
        }
        return list ;
    }

    //nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    @Test
    public void test1() {
        int k = 3;
        int[] matrix1 = new int[]{1,7,11};
        int[] matrix2 = new int[]{2,4,6};
        List<List<Integer>> list = kSmallestPairs(matrix1, matrix2, k);
//        List<List<Integer>> list = kSmallestPairs2(matrix1, matrix2, k);
        System.out.println("list=" + JsonUtil.toJson(list));
    }


    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) - (b[0] + b[1]);
        });
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        // 执行合并多个有序链表的逻辑
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }
        return res;
    }
}
