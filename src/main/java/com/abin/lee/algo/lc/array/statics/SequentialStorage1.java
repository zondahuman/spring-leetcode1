package com.abin.lee.algo.lc.array.statics;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 总结
 * 综上，静态数组的增删查改操作的时间复杂度是：
 *
 * 增：
 * 在末尾追加元素：O(1)。
 * 在中间（非末尾）插入元素：O(N)。
 * 删：
 * 删除末尾元素：O(1)。
 * 删除中间（非末尾）元素：O(N)。
 * 查：给定指定索引，查询索引对应的元素的值，时间复杂度 O(1)。
 * 改：给定指定索引，修改索引对应的元素的值，时间复杂度 O(1)。
 */
public class SequentialStorage1 {
    /**
     * 情况一，数组末尾追加（append）元素
     */
    @Test
    public void test1(){
        int[] arr = new int[10];

        arr[0] = 1;
        arr[1] = 2;

        int a = arr[0];
        System.out.println("a="+a);
//        int b = arr;
        System.out.println("b="+arr.length);
    }

    /**
     * 情况二，数组中间插入（insert）元素
     */
    @Test
    public void test2(){
        int[] arr = new int[10];

        for (int i = 0; i <4 ; i++) {
            arr[i] = i;

        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        for(int i=4; i>2;i--){
            arr[i] = arr[i-1];
        }
        System.out.println("arr="+JsonUtil.toJson(arr));

        arr[2] = 666;
        System.out.println("arr="+ JsonUtil.toJson(arr));
    }

    /**
     * 情况三，数组空间已满
     */
    @Test
    public void test3(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));

        int[] arrNew = new int[20];

        for (int i = 0; i <10 ; i++) {
            arrNew[i] = arr[i];
        }
        System.out.println("arrNew="+JsonUtil.toJson(arrNew));

        arrNew[10] = 10;
        System.out.println("arrNew="+ JsonUtil.toJson(arrNew));
    }


    /**
     * 情况一，删除末尾元素
     */
    @Test
    public void testDelete1(){
        int[] arr = new int[10];

        for (int i = 0; i <5 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));

        arr[4] = -1;
        System.out.println("arrNew="+ JsonUtil.toJson(arr));
    }


    /**
     * 情况二，删除中间元素
     */
    @Test
    public void testDelete2(){
        int[] arr = new int[10];

        for (int i = 0; i <5 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));

        for (int i = 1; i <4 ; i++) {
            arr[i] = arr[i+1];
        }
        arr[4] = -1;
        System.out.println("arrNew="+ JsonUtil.toJson(arr));
    }

































}
