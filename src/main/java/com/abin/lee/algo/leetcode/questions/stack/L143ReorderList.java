package com.abin.lee.algo.leetcode.questions.stack;

import com.abin.lee.algo.leetcode.questions.list.AddTwoNumbers2;
import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/description/
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/description/
 */
public class L143ReorderList {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        if(null == head)
            return;
        ListNode dummy = head;
        Stack<ListNode> stack = new Stack<>();
        while(null != dummy){
            stack.push(dummy);
            dummy = dummy.next;
        }
        ListNode p = head;
        while(null != p){
            ListNode listNode = stack.pop();
            ListNode next = p.next ;
            if(next == listNode || listNode.next == next) {
                listNode.next = null;
                break;
            }
            p.next = listNode;
            listNode.next = next;
            p = next;
        }
    }


    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

//        ListNode listNode = reorderList(l1);
        reorderList(l1);
        System.out.println("listNode=" + JsonUtil.toJson(l1));
    }
}
