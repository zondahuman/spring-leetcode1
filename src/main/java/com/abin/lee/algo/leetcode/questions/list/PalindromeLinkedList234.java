package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 * 234. Palindrome Linked List
 * https://labuladong.online/algo/data-structure/palindrome-linked-list/
 */
public class PalindromeLinkedList234 {
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
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head ;
        while(null != fast && null != fast.next){
            slow = slow.next ;
            fast = fast.next.next;
        }
        if(null != fast)
            slow = slow.next;
        ListNode left = head ;
        ListNode right = reverse(slow);
        while(null != right){
            if(left.val  != right.val)
                return false ;
            left = left.next;
            right = right.next ;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head ;
        ListNode pre = null;
        while(null != cur){
            ListNode next = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = next ;
        }
        return pre ;
    }



    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head ;
        while(null != fast && null != fast.next){
            slow = slow.next ;
            fast = fast.next.next;
        }
        if(null != fast)
            slow = slow.next ;
        ListNode left = head ;
        ListNode right = null;

        ListNode cur = slow ;
        while(null != cur){
            ListNode next = cur.next;
            cur.next = right ;
            right = cur ;
            cur = next ;
        }

        while(null != right){
            if(left.val  != right.val)
                return false ;
            left = left.next ;
            right = right.next ;
        }
        return true ;
    }




    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(2);
        ListNode l14 = new ListNode(1);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

//        Boolean flag = isPalindrome(l1);
        Boolean flag = isPalindrome2(l1);
        System.out.println("flag=" + flag);
    }



}
