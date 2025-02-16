package com.abin.lee.algo.lc.hash.table;

import com.abin.lee.algo.lc.list.doubles.DoubleListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable1 {


    @Test
    public void test1(){
        // 错误示例
        // 把可变类型作为 HashMap 的 key
        Map<ArrayList<Integer>, Integer> map = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);

        map.put(arr, 999);
        System.out.println(map.containsKey(arr)); // true
        System.out.println(map.get(arr)); // 999

        arr.add(3);
        // 出现严重 bug，键值对丢失
        System.out.println(map.containsKey(arr)); // false
        System.out.println(map.get(arr)); // null

        // 此时 map 底层的 table 中，arr 的键值对数据依然存在
        // 但是由于 arr 的 hashCode 改变了，此键值对无法被查找到
        // 这也会导致内存泄漏，因为这个 arr 变量被 map 引用着，无法被垃圾回收
    }




}
