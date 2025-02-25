package com.abin.lee.algo.leetcode.questions.list;

/**
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 * 264. 丑数 II
 * https://leetcode.cn/problems/ugly-number-ii/description/
 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/
 */
public class TwoSixFourUglyNumberII {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        TwoThreeMergekSortedLists.ListNode next;

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
        int[] ugly = new int[n];
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
                product5 = 5 * ugly[5];
                p5++;
            }
        }
        return ugly[n];
    }


}
