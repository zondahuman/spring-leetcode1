package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/description/
 * https://labuladong.online/algo/essential-technique/array-two-pointers-summary/
 */
public class ReverseString344 {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1 ;
        while(left < right){
            char temp = s[left];
            s[left] = s[right] ;
            s[right] = temp;
            left++;
            right--;
        }
    }


    @Test
    public void test1() {
        char[] array = new char[]{'h','e','l','l','o'};
        reverseString(array);
        System.out.println("array=" + JsonUtil.toJson(array));
    }


}
