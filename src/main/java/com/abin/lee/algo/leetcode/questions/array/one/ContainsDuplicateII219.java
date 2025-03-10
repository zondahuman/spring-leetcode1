package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 * https://labuladong.online/algo/problem-set/sliding-window/#slug_contains-duplicate-ii
 */
public class ContainsDuplicateII219 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 0;
        Set<Integer> window = new HashSet<>();
        while (right < nums.length) {
            if(window.contains(nums[right])){
                return true;
            }
            window.add(nums[right]);
            right++;
            while(right-left>k){
                window.remove(nums[left]) ;
                left++;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        int[] array = new int[]{1,2,3,1};
        int target = 3 ;
//        int[] array = new int[]{1,2,3,1,2,3};
//        int target = 2 ;
//        int[] array = new int[]{99,99};
//        int target = 2 ;
        boolean result = containsNearbyDuplicate(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
