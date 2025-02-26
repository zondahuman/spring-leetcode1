package com.abin.lee.algo.leetcode.questions.list;

/**
 * 19. Remove Nth Node From End of List
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndofList19 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(null != first){
            first = first.next ;
            second = second.next ;
        }
        second.next = second.next.next ;
        return dummy.next;
    }


}
