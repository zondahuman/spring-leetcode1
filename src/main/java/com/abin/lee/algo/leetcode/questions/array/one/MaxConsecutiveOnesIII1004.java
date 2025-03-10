package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 1004. 最大连续1的个数 III
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * https://labuladong.online/algo/problem-set/sliding-window/
 */
public class MaxConsecutiveOnesIII1004 {
    /**
     * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：[1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int windowOne = 0;
        int result = 0;
        while (right < nums.length) {
            if(nums[right] == 1)
                windowOne++;
            right++;
            while(right-left-windowOne>k){
                if(nums[left] == 1)
                    windowOne--;
                left++;
            }
            result = Math.max(result, right-left);
        }
        return result;
    }


    @Test
    public void test1() {
        int[] array = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int target = 2 ;
        int result = longestOnes(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }




}
