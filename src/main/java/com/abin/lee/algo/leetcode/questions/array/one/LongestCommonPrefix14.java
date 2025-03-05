package com.abin.lee.algo.leetcode.questions.array.one;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i <count ; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]) ;
            if(prefix.length() == 0)
                break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0 ;
        while(index<length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }


}
