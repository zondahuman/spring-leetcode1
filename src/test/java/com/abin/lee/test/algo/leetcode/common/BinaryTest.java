package com.abin.lee.test.algo.leetcode.common;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

public class BinaryTest {

    @Test
    public void test1() {
        int num1 = 1 ;
        System.out.println("list-num1=" + JsonUtil.toJson(num1));
        num1 = num1 << 1;
        System.out.println("num1 << 1-num1=" + JsonUtil.toJson(num1));
        int num2 = num1 | 0 ;
        System.out.println("num1 | 0-num2=" + JsonUtil.toJson(num2));
        int num3 = num1 | 1 ;
        System.out.println("num1 | 1-num3=" + JsonUtil.toJson(num3));
        int num4 = num1 << 1 | 0 ;
        System.out.println("num1 << 1 | 0-num4=" + JsonUtil.toJson(num4));
    }

    @Test
    public void test2() {
        int num1 = 1 ;
        System.out.println("list-num1=" + JsonUtil.toJson(num1));
        num1 = num1 << 1;
        System.out.println(" num1 >> 1-num1=" + JsonUtil.toJson(num1));
    }




}
