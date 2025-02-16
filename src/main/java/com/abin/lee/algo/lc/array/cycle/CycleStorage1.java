package com.abin.lee.algo.lc.array.cycle;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 环形数组
 */
public class CycleStorage1 {

    /**
     * 情况一，数组末尾追加（append）元素
     */
    @Test
    public void test1(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 0;
        int j =0;
        while(i<arr.length){
            if(j>10)
                break;
            System.out.println("arr[i]="+arr[i]);
            i=(i+1)% arr.length;
            j++;
        }
    }

    /**
     * 情况一，数组末尾追加（append）元素
     */
    @Test
    public void test2(){
        // 长度为 5 的数组
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 0;
// 模拟环形数组，这个循环永远不会结束
        while (i < arr.length) {
            System.out.println(arr[i]);
            i = (i + 1) % arr.length;
        }
    }


    /**
     * 情况一，数组末尾追加（append）元素
     */
    @Test
    public void test3(){
        // 长度为 5 的数组
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 2 % 5;
        System.out.println(i);

    }




















}
