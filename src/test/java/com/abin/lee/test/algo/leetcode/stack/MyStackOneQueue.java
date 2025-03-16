package com.abin.lee.test.algo.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackOneQueue {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStackOneQueue() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i <queue.size() ; i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll(); // 由于 push 操作后，最新的元素总是在 queue1 中，因此直接 poll 即可
    }

    /** Get the top element. */
    public int top() {
        return queue.peek(); // 返回 queue1 的队头元素，即栈顶元素
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty(); // 判断 queue1 是否为空即可
    }


    public static void main(String[] args) {
        MyStackOneQueue myStack = new MyStackOneQueue();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("queue="+myStack.queue);
        int result = myStack.pop();
        System.out.println("result="+result+",queue="+myStack.queue);
    }



}
