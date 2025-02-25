package com.abin.lee.algo.leetcode.questions.list;

/**
 * 86. Partition List	86. 分隔链表
 * https://leetcode.cn/problems/partition-list/description/
 */
public class PartitionList86 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while(null != p){
            if(p.val < x){
                p1.next = p ;
                p1 = p1.next;
            }else{
                p2.next = p ;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }







}
