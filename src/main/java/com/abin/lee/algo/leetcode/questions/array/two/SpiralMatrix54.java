package com.abin.lee.algo.leetcode.questions.array.two;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
public class SpiralMatrix54 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper = 0, lower = m - 1;
        int left = 0, right = n - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < m * n) {
            if (upper <= lower) {
                //left --> right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[upper][i]);
                }
                upper++;
            }
            if (left <= right) {
                //upper--->lower
                for (int i = upper; i <= lower; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            if (upper <= lower) {
                //right-->left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[lower][i]);
                }
                lower--;
            }
            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }


    @Test
    public void test1() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = spiralOrder(array);
        System.out.println("result=" + JsonUtil.toJson(result));
    }


}
