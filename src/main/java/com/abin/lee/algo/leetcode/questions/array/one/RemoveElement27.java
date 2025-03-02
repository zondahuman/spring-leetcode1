package com.abin.lee.algo.leetcode.questions.array.one;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 */
public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        int count = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast] ;
                slow ++ ;
            }
            fast++;
        }
        return slow ;
    }


}
