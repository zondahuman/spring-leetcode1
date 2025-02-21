package com.abin.lee.algo.leetcode.questions.list;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 
 */
public class OneSixZeroIntersectionofTwoLinkedLists {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode p1 =headA;
       ListNode p2 = headB ;
       while(p1 != p2){
           if(p1 == null){
               p1 = headB ;
           }else{
               p1 = p1.next;
           }
           if(p2 == null){
               p2 = headA ;
           }else{
               p2 = p2.next ;
           }
       }
       return p1;
    }

}
