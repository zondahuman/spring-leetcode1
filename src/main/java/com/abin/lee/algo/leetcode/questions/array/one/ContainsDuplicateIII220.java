package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * https://leetcode.cn/problems/contains-duplicate-iii/description/
 * https://labuladong.online/algo/problem-set/sliding-window/#slug_contains-duplicate-iii
 */
public class ContainsDuplicateIII220 {
    /**
     * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
     * 找出满足下述条件的下标对 (i, j)：
     * i != j,
     * abs(i - j) <= indexDiff
     * abs(nums[i] - nums[j]) <= valueDiff
     * 如果存在，返回 true ；否则，返回 false 。
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0, right = 0;
        TreeSet<Integer> window = new TreeSet<>();
        while(right < nums.length){
           int rvalue = nums[right];
           Integer ceil = window.ceiling(rvalue);
           if(null != ceil && ceil - rvalue <=valueDiff)
               return true;
           Integer floor = window.floor(rvalue);
           if(null != floor && rvalue - floor <= valueDiff )
               return true;
            window.add(rvalue);
            right++;
            if(right-left>indexDiff){
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }




    @Test
    public void test1() {
        int[] array = new int[]{1,5,9,1,5,9};
        int indexDiff = 2 ;
        int valueDiff = 3 ;

        boolean result = containsNearbyAlmostDuplicate(array, indexDiff, valueDiff);
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
