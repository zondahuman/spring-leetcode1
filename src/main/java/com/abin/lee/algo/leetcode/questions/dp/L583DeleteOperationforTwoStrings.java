package com.abin.lee.algo.leetcode.questions.dp;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 * https://labuladong.online/algo/dynamic-programming/longest-common-subsequence/
 */
public class L583DeleteOperationforTwoStrings {

    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     * 每步 可以删除任意一个字符串中的一个字符。
     * 示例 1：
     *
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     * 示例  2:
     *
     * 输入：word1 = "leetcode", word2 = "etco"
     * 输出：4
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        result = dp[m][n];
        return m-result + n - result;
    }


}
