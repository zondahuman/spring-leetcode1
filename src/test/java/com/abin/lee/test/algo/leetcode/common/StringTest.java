package com.abin.lee.test.algo.leetcode.common;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

public class StringTest {

    @Test
    public void test1() {
        StringBuilder builder = new StringBuilder();
        builder.append("1");
        System.out.println("list-last=" + JsonUtil.toJson(builder.toString()));
        builder.append("2");
        System.out.println("list-last=" + JsonUtil.toJson(builder.toString()));
        builder.deleteCharAt(builder.length() - 1);
        System.out.println("list-last=" + JsonUtil.toJson(builder.toString()));
    }

    @Test
    public void test2() {
        String str1 = "a";
        String str2 = "ab";
        String str3 = "abc";
        Boolean flag = str1.equals(str2);
        System.out.println("list-flag=" + JsonUtil.toJson(flag));
        Integer flag2 = str1.compareTo(str2);
        System.out.println("str1.compareTo(str2)=" + JsonUtil.toJson(flag2));
        Integer flag3 = str2.compareTo(str1);
        System.out.println("str1.compareTo(str2)=" + JsonUtil.toJson(flag3));
    }












}
