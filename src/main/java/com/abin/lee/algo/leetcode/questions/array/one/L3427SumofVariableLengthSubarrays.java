package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 3427. 变长子数组求和
 * https://leetcode.cn/problems/sum-of-variable-length-subarrays/description/
 * https://labuladong.online/algo/data-structure/prefix-sum/
 */
public class L3427SumofVariableLengthSubarrays {
    /**
     *
     * @param nums
     * @return
     */
    public int subarraySum(int[] nums) {
        int m = nums.length ;
        int[] sums = new int[m+1] ;
        for (int i = 1; i <=m ; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        int result = 0;
        for (int i = 1; i <=m ; i++) {
            int start = Math.max(0, i-1-nums[i-1]);
            result += sums[i] - sums[start];
        }
        return result;
    }

    public int subarraySum2(int[] nums) {
        int m = nums.length ;
        int[] sums = new int[m+1] ;
        for (int i = 0; i <m ; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int result = 0;
        for (int i = 0; i <m ; i++) {
            int start = Math.max(0, i-nums[i]);
            result += sums[i+1] - sums[start];
        }
        return result;
    }

    @Test
    public void testMinEatingSpeed() {
//        int[] array = new int[]{3,6,7,11};
//        int target = 8 ;
//        int[] array = new int[]{30,11,23,4,20};
//        int target = 5 ;
        int[] array = new int[]{2,3,1};
        int target = 11 ;
        int result = subarraySum(array);
//        int result = subarraySum2(array);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
