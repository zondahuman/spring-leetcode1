package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers2 {
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
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode dummy1 = l1;
        ListNode dummy2 = l2;
        int carry = 0;
        while (null != dummy1 || null != dummy2 || carry > 0) {
            int val = carry;
            if (null != dummy1) {
                val += dummy1.val;
                dummy1 = dummy1.next;
            }
            if (null != dummy2) {
                val += dummy2.val;
                dummy2 = dummy2.next;
            }
            carry = val / 10;
            int yu = val % 10;
            p.next = new ListNode(yu);
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    @Test
    public void test1() {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }


}
