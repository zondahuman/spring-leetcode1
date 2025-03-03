package com.abin.lee.algo.leetcode.questions.list;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 61. Rotate List	61. 旋转链表
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class RotateList61 {
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
     * 这个题，不要真傻乎乎地一个一个去移动链表节点，我给你翻译翻译，其实就是将链表的后 k 个节点移动到链表的头部嘛，反应过来没有？
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || head.next == null)
            return head;
        int n = 1;
        ListNode tail = head;
        while (null != tail.next) {
            tail = tail.next;
            n++;
        }
        k %= n;
        if (k == 0)
            return head;
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (null != temp) {
                temp = temp.next;
            }
        }
        ListNode fast = temp, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }


    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(6);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

//        ListNode listNode = reverseBetween(l1);
        ListNode listNode = rotateRight(l1, 2);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));

        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(2);

        l2.next = l21;
        l21.next = l22;
        ListNode listNode2 = rotateRight(l1, 4);
    }

    @Test
    public void test2() {
        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(2);

        l2.next = l21;
        l21.next = l22;
        ListNode listNode = rotateRight(l2, 4);
        System.out.println("listNode=" + JsonUtil.toJson(listNode));
    }
}
