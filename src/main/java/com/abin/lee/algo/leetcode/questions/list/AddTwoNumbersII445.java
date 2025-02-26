package com.abin.lee.algo.leetcode.questions.list;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/description/
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/
 */
public class AddTwoNumbersII445 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while(null != l1){
            stack1.push(l1.val) ;
            l1 = l1.next ;
        }
        Stack<Integer> stack2 = new Stack<>();
        while(null != l2){
            stack2.push(l2.val) ;
            l2 = l2.next ;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry >0){
            int val = carry ;
            if(!stack1.isEmpty()){
                val += stack1.pop();
            }
            if(!stack2.isEmpty()){
                val += stack2.pop() ;
            }
            carry = val / 10;
            int yu = val % 10 ;
            ListNode temp = new ListNode(yu);
            temp.next = dummy.next ;
            dummy.next = temp ;
        }
        return dummy.next ;
    }

}
