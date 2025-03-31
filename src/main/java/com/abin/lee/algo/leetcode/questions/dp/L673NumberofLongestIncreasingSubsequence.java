package com.abin.lee.algo.leetcode.questions.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 673. 最长递增子序列的个数
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/description/
 *
 */
public class L673NumberofLongestIncreasingSubsequence {

    /**
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     * 注意 这个数列必须是 严格 递增的。
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, ans = 0 ;
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]){
//                        dp[i] =  dp[j] + 1;
                        dp[i] =  Math.max(dp[i], dp[j] + 1);
                        cnt[i] = cnt[j] ;
                    }else if(dp[j]+1 == dp[i]){
                        cnt[i] += cnt[j] ;
                    }
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i] ;
                ans = cnt[i];
            }else if(dp[i] == maxLen){
                ans += cnt[i] ;
            }
        }
        return ans;
    }


}
