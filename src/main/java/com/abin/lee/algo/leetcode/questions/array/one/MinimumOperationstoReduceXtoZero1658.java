package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 * https://labuladong.online/algo/problem-set/sliding-window/
 */
public class MinimumOperationstoReduceXtoZero1658 {
    /**
     * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
     * <p>
     * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,4,2,3], x = 5
     * 输出：2
     * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
     * 示例 2：
     * <p>
     * 输入：nums = [5,6,7,8,9], x = 4
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [3,2,20,1,1,3], x = 10
     * 输出：5
     * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
     *
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int sum = 0, m = nums.length;
        for (int i = 0; i < m; i++) {
            sum +=  nums[i];
        }
        int target = sum - x;
        int left = 0, right = 0;
        int windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < m) {
            windowSum += nums[right];
            right++;
            while (windowSum > target && left < right) {
                windowSum -= nums[left];
                left++;
            }
            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : m - maxLen;
    }


    @Test
    public void test1() {
        int[] nums = new int[]{1, 1, 4, 2, 3};
        int x = 5;
        int result = minOperations(nums, x);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
