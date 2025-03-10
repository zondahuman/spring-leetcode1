package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 424. 替换后的最长重复字符
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 * https://labuladong.online/algo/problem-set/sliding-window/
 */
public class LongestRepeatingCharacterReplacement424 {
    /**
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
     * 示例 1：
     * <p>
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * <p>
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     * 可能存在其他的方法来得到同样的结果。
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] windowCharCount = new int[26];
        int maxCount = 0;
        int result = 0;
        while (right < s.length()) {
            int charCount = s.charAt(right) - 'A';
            windowCharCount[charCount]++;
            maxCount = Math.max(maxCount, windowCharCount[charCount]);
            right++;
            while (right - left - maxCount > k) {
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }


    @Test
    public void test1() {
        String str1 = "ABAB";
        int k = 2;
        int result = characterReplacement(str1, k);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
