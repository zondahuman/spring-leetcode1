package com.abin.lee.algo.leetcode.questions.dp;

import com.abin.lee.algo.leetcode.questions.tree.binary.L104MaximumDepthofBinaryTree;
import org.junit.Test;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/description/
 * https://leetcode.com/problems/fibonacci-number/description/
 */
public class L509FibonacciNumber {

    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给定 n ，请计算 F(n) 。
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }


    @Test
    public void test() {
        int n = 2;
        int result = fib(n);
        System.out.println("result=" + result);
        int nn = 4;
        int resultnn = fib(nn);
        System.out.println("resultnn=" + resultnn);
    }


    public int fib2(int n) {
        int[] memo = new int[n+1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n <= 1)
            return n;
        if (memo[n] != 0)
            return memo[n];
        return dp(memo, n - 1) + dp(memo, n - 2);
    }




}
