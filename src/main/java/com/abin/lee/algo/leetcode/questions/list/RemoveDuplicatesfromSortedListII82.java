package com.abin.lee.algo.leetcode.questions.list;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class RemoveDuplicatesfromSortedListII82 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyDup = new ListNode(-1);
        ListNode dummyUniq = new ListNode(-1);
        ListNode p = head ;
        ListNode dup = dummyDup ;
        ListNode uniq = dummyUniq ;
        while(null != p){
            if((p.next != null && p.val == p.next.val) || p.val == dup.val){
                dup.next = p ;
                dup = dup.next ;
            }else{
                uniq.next = p;
                uniq = uniq.next ;
            }
            p = p.next ;
            dup.next = null;
            uniq.next = null;
        }
        return dummyUniq.next;
    }

}
