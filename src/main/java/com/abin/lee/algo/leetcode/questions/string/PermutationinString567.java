package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/description/
 * https://labuladong.online/algo/essential-technique/sliding-window-framework/
 */
public class PermutationinString567 {
    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。
     *
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * 示例 1：
     *
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char character:s1.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0 ;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).intValue() == need.get(c).intValue())
                    valid++;
            }
            while(right-left>=s1.length()){
                if(valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)) {
                    if (window.get(d).intValue() == need.get(d).intValue())
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }



    @Test
    public void test1() {
        String str1 = "ab";
        String str2 = "eidbaooo";
        Boolean result = checkInclusion(str1, str2);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }





}
