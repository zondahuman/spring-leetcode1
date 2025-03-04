package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 * https://labuladong.online/algo/problem-set/array-two-pointers/
 */
public class SquaresofaSortedArray977 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int low = 0, high = nums.length-1;
        int p = nums.length-1;
        int[] result = new int[nums.length];
        while(low<=high){
            int lower = nums[low] * nums[low];
            int higher = nums[high] * nums[high] ;
            if(lower > higher){
                result[p] = lower;
                low++;
            }else{
                result[p] = higher ;
                high--;
            }
            p--;
        }
        return result;
    }


    @Test
    public void test2() {
        int[] array = new int[]{-4,-1,0,3,10};
        int target = 9 ;
        int[] result = sortedSquares(array);
        System.out.println("array=" + JsonUtil.toJson(array));
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
