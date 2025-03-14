package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode.cn/problems/koko-eating-bananas/description/
 * https://labuladong.online/algo/frequency-interview/binary-search-in-action/
 */
public class L875KokoEatingBananas {
    /**
     * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
     * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(func(piles, mid) <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    // f(x)函数计算给定速度x下吃完所有香蕉所需的总小时数
    public long func(int[] piles, int x){
        long hours = 0; // 初始化总小时数
        for (int i = 0; i <piles.length ; i++) {// 遍历每堆香蕉
            hours += piles[i]/x; // 每堆香蕉按当前速度x吃掉需要的时间
            if(piles[i] % x >0){ // 如果不能整除，说明这堆香蕉最后还需要额外一个小时才能吃完
                hours++; // 增加一小时
            }
        }
        return hours; // 返回总小时数
    }


    @Test
    public void testMinEatingSpeed() {
//        int[] array = new int[]{3,6,7,11};
//        int target = 8 ;
//        int[] array = new int[]{30,11,23,4,20};
//        int target = 5 ;
        int[] array = new int[]{30,11,23,4,20};
        int target = 6 ;
        int result = minEatingSpeed(array, target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
