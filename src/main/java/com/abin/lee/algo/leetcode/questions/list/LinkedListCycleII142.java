package com.abin.lee.algo.leetcode.questions.list;

/**
 * 142. Linked List Cycle II	142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycleII142 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(null == head || null == head.next)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(null !=fast && null != fast.next){
            slow = slow.next ;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(null == fast || null == fast.next){
            return null;
        }
        slow = head ;
        while(slow != fast){
            slow = slow.next ;
            fast = fast.next;
        }
        return slow;
    }

}
