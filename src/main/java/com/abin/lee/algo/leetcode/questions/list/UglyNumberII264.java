package com.abin.lee.algo.leetcode.questions.list;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 * 264. 丑数 II
 * https://leetcode.cn/problems/ugly-number-ii/description/
 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/
 */
public class UglyNumberII264 {
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
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * <p>
     * 丑数 就是质因子只包含 2、3 和 5 的正整数。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int product2 = 1, product3 = 1, product5 = 1;
        int[] ugly = new int[n+1];
        int p = 1;
        while (p <= n) {
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p] = min;
            p++;
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        return ugly[n];
    }


    @Test
    public void test1() {
        int count = 10;
        int result = nthUglyNumber(count);
        System.out.println("result=" + result);
    }


    public int nthUglyNumberByPriority(int n) {
        int[] factors = new int[]{2,3,5};
        Set<Long> sets = new HashSet<Long>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue();
        priorityQueue.offer(1L);
        sets.add(1L) ;
        int ugly = 0 ;
        for (int i = 0; i <n ; i++) {
            long cur = priorityQueue.poll();
            ugly = (int) cur;
            for(int factor: factors){
                long next = factor * cur ;
                if(sets.add(next)){
                    priorityQueue.offer(next);
                }
            }
        }
        return ugly;
    }
}
