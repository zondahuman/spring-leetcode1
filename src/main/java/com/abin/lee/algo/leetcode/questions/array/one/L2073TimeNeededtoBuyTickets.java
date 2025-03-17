package com.abin.lee.algo.leetcode.questions.array.one;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 2073. 买票需要的时间
 * https://leetcode.cn/problems/time-needed-to-buy-tickets/description/
 * https://labuladong.online/algo/problem-set/queue/
 */
public class L2073TimeNeededtoBuyTickets {
    /**
     *
     * @param tickets
     * @param k
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length ;
        int result = 0;
        for (int i = 0; i <n ; i++) {
            if(i<=k){
                result += Math.min(tickets[i], tickets[k]);
            }else{
                result += Math.min(tickets[i], tickets[k-1]);
            }
        }
        return result;
    }



    @Test
    public void test1() {
        int[] array = new int[]{2,3,2};
        int k = 2;
        int result = timeRequiredToBuy(array, k);
        System.out.println("result=" + JsonUtil.toJson(result));
    }



}
