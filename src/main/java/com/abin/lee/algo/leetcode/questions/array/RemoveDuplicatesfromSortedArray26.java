package com.abin.lee.algo.leetcode.questions.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesfromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        while(fast<nums.length){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast] ;
            }
            fast++;
        }
        return slow+1 ;
    }


    public int removeDuplicates2(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for (int i = 0; i <nums.length-1 ; i++) {
            duplicate.add(nums[i]);
        }

        return duplicate != null ? duplicate.size() : 0 ;
    }
}
