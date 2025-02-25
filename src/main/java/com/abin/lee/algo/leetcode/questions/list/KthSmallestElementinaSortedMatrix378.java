package com.abin.lee.algo.leetcode.questions.list;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/
 */
public class KthSmallestElementinaSortedMatrix378 {
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
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     *
     * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];
       });
        for (int i = 0; i <matrix.length ; i++) {
            priorityQueue.offer(new int[]{matrix[i][0], i, 0});
        }
        int res = -1;
        while(!priorityQueue.isEmpty() && k>0){
            int[] cur = priorityQueue.poll();
            res = cur[0];
            k--;
            int row = cur[1]; int col = cur[2];
            if (col+1<matrix[row].length) {
                priorityQueue.offer(new int[]{matrix[row][col+1], row, col+1});
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int k = 8;
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int result = kthSmallest(matrix, k);
        System.out.println("result=" + result);
    }



}
