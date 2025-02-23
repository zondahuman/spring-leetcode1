package com.abin.lee.algo.leetcode.questions.list;

/**
 * 86. Partition List	86. 分隔链表
 * https://leetcode.cn/problems/partition-list/description/
 */
public class EightSixPartitionList {
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
        ListNode p1 = new ListNode(-1);
        ListNode p2 = new ListNode(-1);
        while(null != p){
            if(p.val < x){
                p1.next = p ;
                p1 = p1.next;
            }else{
                p2.next = p ;
                p2 = p2.next;
            }
        }
        
        return null;
    }


}
