package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class L395LongestSubstringwithAtLeastKRepeatingCharacters {

    /**
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
     * 如果不存在这样的子字符串，则返回 0。
     * 示例 1：
     * <p>
     * 输入：s = "aaabb", k = 3
     * 输出：3
     * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 示例 2：
     * <p>
     * 输入：s = "ababbc", k = 2
     * 输出：5
     * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int len = 0;
        for (int i = 1; i <= 26; i++) {
            len = Math.max(len, logestKLetterSubstr(s, k, i));
        }
        return len;
    }

    public int logestKLetterSubstr(String s, int k, int count) {
        int left = 0, right = 0;
        int[] windowCount = new int[26];
        int windowUniqueCount = 0;
        int windowValidCount = 0;
        int result = 0;
        while (right < s.length()) {
            int c = s.charAt(right);
            if (windowCount[c - 'a'] == 0)
                windowUniqueCount++;
            windowCount[c - 'a']++;
            if (windowCount[c - 'a'] == k)
                windowValidCount++;
            right++;
            while (windowUniqueCount > count) {
                int d = s.charAt(left);
                if(windowCount[d -'a'] == k)
                    windowValidCount--;
                windowCount[d - 'a']--;
                if(windowCount[d-'a'] == 0)
                    windowUniqueCount--;
                left++;
            }
            if(windowValidCount == count) {
                result = Math.max(result, right - left);
            }
        }
        return result;
    }



    @Test
    public void test1() {
//        String str1 = "aaabb";
//        int k = 3;
//        int result = longestSubstring(str1, k);
        String str1 = "ababbc";
        int k = 2;
        int result = longestSubstring(str1, k);
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
