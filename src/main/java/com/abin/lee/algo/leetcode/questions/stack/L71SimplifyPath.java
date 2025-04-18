package com.abin.lee.algo.leetcode.questions.stack;

import java.util.Stack;

/**
 * 71. 简化路径
 * https://leetcode.cn/problems/simplify-path/description/
 * https://labuladong.online/algo/problem-set/stack/#slug_simplify-path
 */
public class L71SimplifyPath {
    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
     * 在 Unix 风格的文件系统中规则如下：
     * 一个点 '.' 表示当前目录本身。
     * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
     * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
     * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
     * 返回的 简化路径 必须遵循下述格式：
     *
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String temp : array){
            if(temp.isEmpty() || temp.equals("."))
                continue;
            if(temp.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
                continue;
            }
            stack.push(temp);
        }
        String result = "";
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        return result.isEmpty() ? "/" : result;
    }

}
