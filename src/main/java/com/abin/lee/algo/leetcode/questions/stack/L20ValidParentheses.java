package com.abin.lee.algo.leetcode.questions.stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/
 * https://labuladong.online/algo/problem-set/stack/#slug_valid-parentheses
 */
public class L20ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character cha:s.toCharArray()){
            if(cha == '(' ||cha == '[' ||cha == '{' ){
                stack.push(cha);
            }else {
                if(!stack.isEmpty() && leftOf(cha) == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public char leftOf(char str){
        if(str == ')')
            return '(';
        if(str == '}')
            return '{';
        return '[';
    }

}
