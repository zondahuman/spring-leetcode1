package com.abin.lee.test.algo.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.clear(); // 清空 queue2，确保所有元素都在 queue1 中
        queue1.offer(x); // 将新元素添加到 queue1

        // 将 queue1 中的所有元素转移到 queue2 中，这样 queue1 中只留下最新的元素
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // 交换 queue1 和 queue2 的引用，这样 queue1 总是空的，queue2 总是包含栈中的所有元素
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 由于 push 操作后，最新的元素总是在 queue1 中，因此直接 poll 即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek(); // 返回 queue1 的队头元素，即栈顶元素
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty(); // 判断 queue1 是否为空即可
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        int result = myStack.pop();
        System.out.println("result="+result);
    }



}
