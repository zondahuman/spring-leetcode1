package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * https://labuladong.online/algo/essential-technique/array-two-pointers-summary/
 */
public class MoveZeroes283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = getNonZero(nums, 0);
        for (;len<nums.length;len++) {
            nums[len] = 0;
        }
    }

    public int getNonZero(int[] nums, int k){
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != k){
                nums[slow] = nums[fast] ;
                slow ++;
            }
            fast++;
        }
        return slow ;
    }


    public void moveZeroes2(int[] nums) {
        int len = removeElement(nums, 0);
        for (;len<nums.length;len++) {
            nums[len] = 0;
        }
    }
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test1() {
        int[] array = new int[]{0,1,0,3,12};
        int target = 9 ;
        moveZeroes(array);
        System.out.println("array=" + JsonUtil.toJson(array));
    }




}
