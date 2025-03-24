package com.abin.lee.test.algo.leetcode.common;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

public class CharTest {

    @Test
    public void test1() {
        char str1 = 'a' ;
        System.out.println("list-str1=" + JsonUtil.toJson(str1));
        char str2 = 'a' +1;
        System.out.println("list-str2=" + JsonUtil.toJson(str2));
        char str3 = 'a' +'b';
        System.out.println("list-str3=" + JsonUtil.toJson(str3));
        char str4 = 'a' +3;
        System.out.println("list-str4=" + JsonUtil.toJson(str4));

    }






}
