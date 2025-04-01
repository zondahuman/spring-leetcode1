package com.abin.lee.algo.leetcode.questions.dp;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 * https://labuladong.online/algo/dynamic-programming/edit-distance/
 */
public class L72EditDistance {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化第一列。如果s2为空字符串（j=0），那么将s1[0..i-1]转换成空字符串的最小编辑距离就是将s1中的所有字符删除，即i。
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //初始化第一行。同理，如果s1为空字符串（i=0），那么将空字符串转换成s2[0..j-1]的最小编辑距离就是将s2中的所有字符插入，即j。
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }






}
