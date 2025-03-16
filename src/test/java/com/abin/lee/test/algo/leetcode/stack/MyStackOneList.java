package com.abin.lee.test.algo.leetcode.stack;

import com.abin.lee.algo.lc.list.single.ListNode;
import com.abin.lee.algo.util.JsonUtil;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackOneList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        private ListNode(int val) {
            this.val = val;
        }
    }

    ListNode listNode;

    /** Initialize your data structure here. */
    public MyStackOneList() {
        listNode = new ListNode();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        ListNode dummy = new ListNode(x);
        dummy.next = listNode;
        listNode = dummy;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = listNode.val;
        listNode = listNode.next ;
        return result; // 由于 push 操作后，最新的元素总是在 queue1 中，因此直接 poll 即可
    }

    /** Get the top element. */
    public int top() {
        if(null == listNode){
            return -1;
        }
        int result = listNode.val;
        return result; // 返回 queue1 的队头元素，即栈顶元素
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return null == listNode; // 判断 queue1 是否为空即可
    }


    public static void main(String[] args) {
        MyStackOneList myStack = new MyStackOneList();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("listNode="+ JsonUtil.toJson(myStack.listNode));
        int result = myStack.pop();
        System.out.println("result="+result+",listNode="+JsonUtil.toJson(myStack.listNode));
    }



}
