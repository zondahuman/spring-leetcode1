package com.abin.lee.algo.leetcode.questions.queue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * https://labuladong.online/algo/data-structure/stack-queue/
 */
public class L232ImplementQueueusingStacks {

    static class MyQueue {
        Stack<Integer> stack1, stack2 ;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.empty();
        }
    }

}
