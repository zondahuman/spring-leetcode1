package com.abin.lee.algo.leetcode.questions.array.one;

/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search/description/
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/description/
 */
public class L704BinarySearch {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right-left)/2 ;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid +1 ;
            }
        }
        return -1;
    }


}
