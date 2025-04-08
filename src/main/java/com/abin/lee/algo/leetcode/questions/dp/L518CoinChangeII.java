package com.abin.lee.algo.leetcode.questions.dp;

/**
 * 518. 零钱兑换 II
 * https://leetcode.cn/problems/coin-change-ii/description/
 */
public class L518CoinChangeII {


    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     * 题目数据保证结果符合 32 位带符号整数。
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(j - coins[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}
