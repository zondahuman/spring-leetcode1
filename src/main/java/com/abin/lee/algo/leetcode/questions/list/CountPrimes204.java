package com.abin.lee.algo.leetcode.questions.list;

import org.junit.Test;

import java.util.Arrays;

/**
 * 204. 计数质数
 * https://leetcode.cn/problems/count-primes/description/
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/description/
 * <p>
 * https://labuladong.online/algo/frequency-interview/print-prime-number/
 */
public class CountPrimes204 {
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
     * 质因数，也叫素因数或质因子，是指能整除给定正整数的质数。质数是指只能被1和自身整除的正整数
     * 质数：只有1和它本身两个因数（约数），那么这样的数叫做质数。比如7，只有1和7两个约数。
     * 合数：除了能被1和它本身整除，还能被其他的正整数整除，那么这样的数叫做合数。比如8，有1、2、4和8四个约数。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


    @Test
    public void test1() {
        int count = 10;
        int result = countPrimes(count);
//        int result = countPrimesLa(count) ;
        System.out.println("result=" + result);
    }


}
