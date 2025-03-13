package com.abin.lee.algo.leetcode.lcr;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * LCR 172. 统计目标成绩的出现次数
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/description/
 */
public class LCR172 {
    /**
     * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
     * 示例 1：
     * <p>
     * 输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
     * 输出: 3
     * 示例 2：
     * <p>
     * 输入: scores = [1, 2, 3, 5, 7, 9], target = 6
     * 输出: 0
     *
     * @param scores
     * @param target
     * @return
     */
    public int countTarget(int[] scores, int target) {
        if (null == scores || scores.length == 0)
            return 0;
        int first = findFirst(scores, target);
        if (-1 == first)
            return 0;
        int last = findLast(scores, target);
        int result = last - first + 1;
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
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
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

    @Test
    public void test1() {
        int[] array = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        int target = 4;
//        int[] array = new int[]{1, 2, 3, 5, 7, 9};
//        int target = 6 ;
//        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9};
//        int target = 3;

        int result = countTarget(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
