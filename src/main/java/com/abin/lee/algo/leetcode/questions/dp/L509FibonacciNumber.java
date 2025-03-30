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



    public int fib3(int n) {
        if(n == 0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int fib4(int n) {
        if(n == 0)
            return 0;
        int dp2 = 0;
        int dp1 = 1;
        int dp = 0;
        for (int i = 2; i <=n ; i++) {
            dp = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp ;
        }
        return dp1;
    }

    @Test
    public void test4() {
        int n = 2;
        int result = fib4(n);
        System.out.println("result=" + result);
        int nn = 4;
        int resultnn = fib4(nn);
        System.out.println("resultnn=" + resultnn);
    }




}
