package com.abin.lee.algo.leetcode.lcr;

import com.abin.lee.algo.leetcode.questions.list.AddTwoNumbers2;
import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * LCR 006. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/kLl5u1/description/
 */
public class LCR006 {
    /**
     * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，
     * 所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
     * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        while (low < high) {
            int sum = numbers[low] + numbers[high] ;
            if (sum == target) {
                return new int[] { low, high };
            }else if(sum > target){
                high--;
            }else if(sum < target){
                low++;
            }
        }
        return new int[2];
    }


    @Test
    public void test1() {
        int[] array = new int[]{1,2,4,6,10};
        int target = 8 ;
        int[] result =  twoSum(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }





}
