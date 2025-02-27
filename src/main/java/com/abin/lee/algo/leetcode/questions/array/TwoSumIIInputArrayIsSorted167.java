package com.abin.lee.algo.leetcode.questions.array;

import com.abin.lee.algo.leetcode.questions.list.AddTwoNumbers2;
import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * https://labuladong.online/algo/essential-technique/array-two-pointers-summary/
 */
public class TwoSumIIInputArrayIsSorted167 {

    /**
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
       int left = 0, right = numbers.length - 1;
       while(left<right){
           int sum = numbers[left] + numbers[right];
           if(sum == target){
               return new int[]{left+1, right+1} ;
           } else if (sum < target) {
               left ++ ;
           }else if(sum > target){
               right -- ;
           }
       }
       return new int[]{-1, -1};
    }

    @Test
    public void test1() {
        int[] array = new int[]{2,7,11,15};
        int target = 9 ;
        int[] result = twoSum(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
