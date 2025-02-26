package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/description/
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList206 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head ;
        ListNode pre = null;
        while(null != cur){
            ListNode next = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = next ;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head ;
        head.next = null;
        return last ;
    }


    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

//        ListNode listNode = reverseList(l1);
        ListNode listNode = reverseList2(l1);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }


}
