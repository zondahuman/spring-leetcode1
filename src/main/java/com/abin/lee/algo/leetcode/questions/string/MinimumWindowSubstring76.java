package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法核心代码模板
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/description/
 * https://labuladong.online/algo/essential-technique/sliding-window-framework/
 *
 */
public class MinimumWindowSubstring76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c:t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left =0, right=0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(valid == need.size()){
                // 在这里更新最小覆盖子串
                if(right-left<len){
                    start = left;
                    len = right -left ;
                }
                char d = s.charAt(left) ;
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }


    @Test
    public void test1() {
        String s = "ADOBECODEBANC", t = "ABC";
        String result = minWindow(s, t);
//        String result = longestPalindrome2(str1);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    @Test
    public void test2() {
        String s= "ADOBECODEBANC" ;
        String t= "ABC" ;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        String str1 = "babad";
//        String result = longestPalindrome(str1);
//        String result = longestPalindrome2(str1);
//        System.out.println("result=" + JsonUtil.toJson(result));
    }




}
