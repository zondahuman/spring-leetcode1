package com.abin.lee.algo.leetcode.questions.list;

/**
 * 21. Merge Two Sorted Lists	21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists21 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (null != p1 && null != p2) {
            if (p1.val < p2.val) {
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p2 != null) {
            p.next = p2;
        }
        if (p1 != null) {
            p.next = p1;
        }
        return dummy.next;
    }


}
