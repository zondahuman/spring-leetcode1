package com.abin.lee.algo.leetcode.questions.list;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesfromSortedList83 {
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
     * 83. 删除排序链表中的重复元素
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyDup = new ListNode(-1000);
        ListNode dummyUniq = new ListNode(-1000) ;
        ListNode p = head ;
        ListNode dup = dummyDup ;
        ListNode uniq = dummyUniq ;
        while(null != p){
            if(p.next != null && p.val == p.next.val ){
                dup.next = p.next;
                dup = dup.next ;
                p.next = p.next.next;
            }else{
                uniq.next = p;
                uniq = uniq.next ;
                p = p.next ;
            }
        }
        return dummyUniq.next;
    }


}
