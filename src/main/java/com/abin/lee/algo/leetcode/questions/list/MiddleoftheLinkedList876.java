package com.abin.lee.algo.leetcode.questions.list;

/**
 * 876. Middle of the Linked List	876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class MiddleoftheLinkedList876 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (null == head)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) {
            return slow;
        } else if(fast == null || fast.next == null) {
            return slow;
        }else{
            return slow;
        }
    }



}
