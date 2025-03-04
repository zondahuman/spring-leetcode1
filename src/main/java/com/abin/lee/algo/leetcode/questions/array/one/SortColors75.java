package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/description/
 */
public class SortColors75 {
    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0 ;
        for (int i = 0; i < n ; i++) {
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr] ;
                nums[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i <n ; i++) {
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp ;
                ptr++ ;
            }
        }
    }


    @Test
    public void test1() {
        int[] array = new int[]{2,0,2,1,1,0};
        int target = 9 ;
        sortColors(array);
        System.out.println("array=" + JsonUtil.toJson(array));
    }



}
