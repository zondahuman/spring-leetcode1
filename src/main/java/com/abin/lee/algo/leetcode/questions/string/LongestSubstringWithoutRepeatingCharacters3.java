package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * https://labuladong.online/algo/essential-technique/sliding-window-framework/
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    /**
     * 3. 无重复字符的最长子串
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0 , right = 0;
        int result = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0)+1);
            while(window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            result = Math.max(result, right-left);
        }
        return result;
    }


    @Test
    public void test1() {
        String str1 = "babad";
//        String result = longestPalindrome(str1);
//        String result = longestPalindrome2(str1);
//        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
