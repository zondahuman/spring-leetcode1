package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class MergeSortedArray88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int p = nums1.length-1;
        while(i >=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[p] = nums1[i];
                i--;
            }else{
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
        while(j>=0){
            nums1[p] = nums2[j] ;
            j--;
            p--;
        }
    }


    @Test
    public void test1() {
        int[] array = new int[]{0,1,2,3,4};
        System.out.println("array=" + JsonUtil.toJson(array));
        System.out.println("array.length=" + array.length);
        array[5] = 5;
        System.out.println("array=" + JsonUtil.toJson(array));

    }

    @Test
    public void test2() {
        int[] array = new int[]{0,1,0,3,12};
        int target = 9 ;
//        moveZeroes(array);
        System.out.println("array=" + JsonUtil.toJson(array));
    }

}
