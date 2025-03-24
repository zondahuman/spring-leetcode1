package com.abin.lee.test.algo.leetcode.common;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void test1(){
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("->");
        list.add("333");
        System.out.println("list-before="+ JsonUtil.toJson(list));
        list.removeLast();
        System.out.println("list-last="+ JsonUtil.toJson(list));
    }

    @Test
    public void test2(){
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("->");
        list.add("333");
        System.out.println("list-before="+ JsonUtil.toJson(list));
        list.removeFirst();
        System.out.println("list-last="+ JsonUtil.toJson(list));
    }







}
