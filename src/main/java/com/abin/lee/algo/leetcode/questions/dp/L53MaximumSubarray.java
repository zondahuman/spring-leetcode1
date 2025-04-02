package com.abin.lee.algo.leetcode.questions.dp;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 * https://labuladong.online/algo/dynamic-programming/maximum-subarray/
 */
public class L53MaximumSubarray {


    /**
     * 滑动窗口
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组是数组中的一个连续部分。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;
            // 更新答案
            maxSum = Math.max(maxSum, windowSum);

            while(windowSum < 0){
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum ;
    }


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length ;
        if(0 == n ) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i <n ; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }



    /**
     * 动态规划优化版本
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int n = nums.length ;
        if(0 == n ) return 0;
        int dp0 = nums[0];
        int dp1 = 0, result = dp0;

        for (int i = 1; i <n ; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            result = Math.max(result, dp1);
        }
        return result;
    }


    /**
     * 前缀和数组
     * @param nums
     * @return
     */
    public int maxSubArray4(int[] nums) {
        int n = nums.length ;
        if(0 == n ) return 0;
        int[] preSum = new int[n+1];
        preSum[0] = nums[0];
        for (int i = 1; i <=n ; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int minValue = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            minValue = Math.min(minValue, preSum[i]);
            result = Math.max(result, preSum[i+1] - minValue);
        }
        return result;
    }



}
