package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/
 */
public class ReverseLinkedListII92 {
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
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        ListNode pre = head;
        for (int i = 1; i < left-1; i++) {
            pre = pre.next ;
        }
        pre.next = reverseN(pre.next, right-left+1);
        return head;

    }

    public ListNode reverseN(ListNode head, int n) {
        ListNode pre, cur, nxt ;
        pre = null; cur = head; nxt = head.next;
        while(n > 0){
            cur.next = pre ;
            pre = cur ;
            cur = nxt ;
            if( null != nxt){
                nxt = nxt.next ;
            }
            n--;
        }
        // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
        head.next = cur;
        return pre;
    }


    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(6);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

//        ListNode listNode = reverseBetween(l1);
        ListNode listNode = reverseBetween(l1, 2,4);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }
}
