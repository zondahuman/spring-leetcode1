package com.abin.lee.algo.leetcode.questions.list;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists	23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists23 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy ;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        for(ListNode listNode:lists){
            if(null != listNode)
                priorityQueue.add(listNode);
        }

        while(!priorityQueue.isEmpty()){
            ListNode listNode = priorityQueue.poll();
            p.next = listNode;
            if(listNode.next != null){
                priorityQueue.add(listNode.next);
            }
            p = p.next ;
        }
        return dummy.next ;
    }




}
