package com.abin.lee.algo.leetcode.questions.string;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 67. 二进制求和
 * https://leetcode.cn/problems/add-binary/description
 */
public class L67AddBinary {

    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     * 示例 1：
     * <p>
     * 输入:a = "11", b = "1"
     * 输出："100"
     * 示例 2：
     * <p>
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }


    @Test
    public void test1() {
        String a = "1010";
        String b = "1011";
        String result = addBinary(a, b);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
