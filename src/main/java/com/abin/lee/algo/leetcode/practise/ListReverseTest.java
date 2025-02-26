package com.abin.lee.algo.leetcode.practise;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

public class ListReverseTest {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode cur = head ;
        ListNode pre = null;
        while(null != cur){
            ListNode next = cur.next;
            cur.next = pre ;
            pre = cur ;
            cur = next ;
        }
        return pre ;
    }
    
    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode listNode = reverseList(l1);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }




}
