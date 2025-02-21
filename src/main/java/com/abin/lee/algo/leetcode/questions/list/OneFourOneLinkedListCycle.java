package com.abin.lee.algo.leetcode.questions.list;

/**
 * 141. Linked List Cycle	141. 环形链表
 */
public class OneFourOneLinkedListCycle {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(null != fast && null != fast.next){
            if(slow == fast){
                return true ;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }


}
