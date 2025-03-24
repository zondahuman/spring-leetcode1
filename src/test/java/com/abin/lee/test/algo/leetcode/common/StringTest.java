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














}
