package com.abin.lee.algo.leetcode.questions.array.one;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class L34FindFirstandLastPositionofElementinSortedArray {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * 示例 1：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = findFirst(nums, target);
        int right = findLast(nums, target);
        result[0] = left;
        result[1] = right;
        return result;
    }

    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

    public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

}
