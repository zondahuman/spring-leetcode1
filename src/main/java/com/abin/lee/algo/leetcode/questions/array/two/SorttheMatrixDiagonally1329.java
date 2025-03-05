package com.abin.lee.algo.leetcode.questions.array.two;

import java.util.*;

/**
 * 1329. 将矩阵按对角线排序
 * https://leetcode.cn/problems/sort-the-matrix-diagonally/description/
 * https://labuladong.online/algo/problem-set/array-two-pointers/
 */
public class SorttheMatrixDiagonally1329 {
    /**
     * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。
     * 例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
     * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
     * 这题非常有意思，按照对角线操作二维数组是需要技巧的，即你如何快速判断两个元素坐标是否在同一个对角线上？
     *
     * 直接说结论：在同一个对角线上的元素，其横纵坐标之差是相同的。你画图看看，或者稍微想想就能明白：右下角走一步横纵坐标都会加一，所以他们的差肯定不会变。
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                int key = i-j;
                listMap.putIfAbsent(key, new ArrayList<>());
                listMap.get(key).add(mat[i][j]);
            }
        }
        for (List<Integer> list:listMap.values()){
            Collections.sort(list, Collections.reverseOrder());
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                List<Integer> tempList = listMap.get(i-j);
                mat[i][j] = tempList.remove(tempList.size()-1);
            }
        }
        return mat;
    }



}
