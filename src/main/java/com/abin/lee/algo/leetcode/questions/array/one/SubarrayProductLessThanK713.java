package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 713. 乘积小于 K 的子数组
 * https://leetcode.cn/problems/subarray-product-less-than-k/description/
 * https://labuladong.online/algo/problem-set/sliding-window/#slug_subarray-product-less-than-k
 */
public class SubarrayProductLessThanK713 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     * 示例 1：
     *
     * 输入：nums = [10,5,2,6], k = 100
     * 输出：8
     * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
     * 示例 2：
     *
     * 输入：nums = [1,2,3], k = 0
     * 输出：0
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int windowTimes = 1; //乘积
        int count = 0; //子数组个数
        while(right < nums.length){
            windowTimes *= nums[right];
            right++;
            while(left<right && windowTimes>=k){
                windowTimes/=nums[left];
                left++;
            }
            count += right - left;
        }
        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{10,5,2,6};
        int x = 100;
        int result = numSubarrayProductLessThanK(nums, x);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
