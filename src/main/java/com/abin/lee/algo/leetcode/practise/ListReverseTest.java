package com.abin.lee.algo.leetcode.practise;

import com.abin.lee.algo.leetcode.questions.list.ReverseLinkedList206;
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

    /**
     * 反转链表前 N 个节点
     * https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head, int n){
        if(null == head || head.next == null)
            return head ;
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head.next;
        while(n > 0){
            cur.next = pre ;
            pre = cur ;
            cur = nxt ;
            if(null != nxt){
                nxt = nxt.next;
            }
            n--;
        }
        head.next = cur;
        return  pre;
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

    @Test
    public void test2() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode listNode = reverseList(l1);
        listNode.next.next = listNode ;
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }


    @Test
    public void testReverseN() {
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
        ListNode listNode = reverseN(l1, 3);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }

}
