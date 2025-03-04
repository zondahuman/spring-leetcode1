package com.abin.lee.algo.leetcode.questions.string;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/
 */
public class ValidPalindrome125 {
    /**
     *如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            char temp = s.charAt(i);
            if(Character.isLetterOrDigit(temp)){
                buffer.append(temp);
            }
        }
        String str =  buffer.toString();
        str = str.toLowerCase();
        int low=0, high = str.length()-1;
        while(low<=high){
            if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }else{
                return false;
            }
        }
        return true;
    }

}
