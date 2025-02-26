package com.abin.lee.algo.leetcode.questions.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 */
public class IntersectionofTwoLinkedLists160 {
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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> sets = new HashSet<>();
        ListNode temp = headA;
        while(null != temp){
            sets.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(null != temp){
            if(sets.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
