package com.abin.lee.algo.leetcode.questions.string;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 *
 */
public class L121BestTimetoBuyandSellStock {

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        dp[0] = prices[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1] + prices[i];
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
//            int result =
//            result = Math.max(prices[i], result);
        }
        return result;
    }
}
