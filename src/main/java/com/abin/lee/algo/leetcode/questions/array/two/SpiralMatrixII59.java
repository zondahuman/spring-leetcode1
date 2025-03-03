package com.abin.lee.algo.leetcode.questions.array.two;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

import java.util.List;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrixII59 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int upper = 0, lower = n-1;
        int left = 0, right = n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while(num <= n*n){
            if(upper <= lower){
                //left-->right
                for (int i = left; i <=right ; i++) {
                    matrix[upper][i] = num++;
                }
                upper++;
            }
            if(left <= right){
                //upper-->lower
                for (int i = upper; i <= lower ; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }
            if(upper <= lower){
                //right --> left
                for (int i = right; i >=left ; i--) {
                    matrix[lower][i] = num++;
                }
                lower--;
            }
            if(left <= right){
                //lower-->upper
                for (int i = lower; i >=upper ; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }


    @Test
    public void test1() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 3;
        int[][]  result = generateMatrix(target);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

}
