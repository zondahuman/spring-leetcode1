package com.abin.lee.algo.leetcode.questions.string;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/
 */
public class ValidPalindrome125 {
    /**
     *
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
