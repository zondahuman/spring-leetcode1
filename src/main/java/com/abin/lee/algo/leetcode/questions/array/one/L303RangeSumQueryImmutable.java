package com.abin.lee.algo.leetcode.questions.array.one;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable/description/
 * https://labuladong.online/algo/data-structure/prefix-sum/
 */
public class L303RangeSumQueryImmutable {


    public static class NumArray{
        int[] sums;
        public NumArray(int[] nums) {
           int n = nums.length;
           sums = new int[n+1];
            for (int i = 0; i <n ; i++) {
                sums[i+1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right+1]-sums[left];
        }

    }

}
