package com.abin.lee.algo.leetcode.questions.list;

/**
 * 142. Linked List Cycle II	142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class OneFourTwoLinkedListCycleII {
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
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(null !=fast && null != fast.next){
            if(slow == fast){

            }
        }

        return null;
    }

}
