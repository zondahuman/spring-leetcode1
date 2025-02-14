package com.abin.lee.algo.lc.array.dynamic;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 动态数组
 */
public class DynamicStorage1 {

    /**
     * 情况一，数组末尾追加（append）元素
     */
    @Test
    public void test1(){
// 创建动态数组
// 不用显式指定数组大小，它会根据实际存储的元素数量自动扩缩容
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // 在末尾追加元素，时间复杂度 O(1)
            arr.add(i);
        }
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 在中间插入元素，时间复杂度 O(N)
// 在索引 2 的位置插入元素 666
        arr.add(2, 666);
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 在头部插入元素，时间复杂度 O(N)
        arr.add(0, -1);
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 删除末尾元素，时间复杂度 O(1)
        arr.remove(arr.size() - 1);
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 删除中间元素，时间复杂度 O(N)
// 删除索引 2 的元素
        arr.remove(2);
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 根据索引查询元素，时间复杂度 O(1)
        int a = arr.get(0);

// 根据索引修改元素，时间复杂度 O(1)
        arr.set(0, 100);
        System.out.println("arr="+ JsonUtil.toJson(arr));
// 根据元素值查找索引，时间复杂度 O(N)
        int index = arr.indexOf(666);
    }

}
