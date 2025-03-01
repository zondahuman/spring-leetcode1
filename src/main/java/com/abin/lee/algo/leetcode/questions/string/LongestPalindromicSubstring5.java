package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * https://labuladong.online/algo/essential-technique/array-two-pointers-summary/
 */
public class LongestPalindromicSubstring5 {
    /**
     * 给你一个字符串 s，找到 s 中最长的 回文 子串。
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindromeAtomic(s, i, i);
            String s2 = palindromeAtomic(s, i, i + 1);
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    public String palindromeAtomic(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
           left--;
           right++;
        }
        return s.substring(left+1, right);
    }



    @Test
    public void test1() {
        String str1 = "babad";
        String result = longestPalindrome(str1);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
