package com.abin.lee.algo.leetcode.questions.dp;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 * https://labuladong.online/algo/dynamic-programming/maximum-subarray/
 */
public class L53MaximumSubarray {


    /**
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

}
