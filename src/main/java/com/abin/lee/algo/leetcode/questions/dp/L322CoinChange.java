package com.abin.lee.algo.leetcode.questions.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/description/
 */
public class L322CoinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 你可以认为每种硬币的数量是无限的。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1)
                continue;
            result = Math.min(result, subProblem + 1);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp2(coins, amount);
    }

    public int dp2(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo[amount] != -666)
            return memo[amount];
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp2(coins, amount - coin);
            if (subProblem == -1)
                continue;
            result = Math.min(result, subProblem + 1);
        }
        memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return memo[amount];
    }


    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin:coins){
                if(i - coin <0)
                    continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        return dp[amount] == amount +1 ? -1 : dp[amount];
    }

}
