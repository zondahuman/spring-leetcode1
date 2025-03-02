package com.abin.lee.algo.leetcode.questions.array.two;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/description/
 */
public class RotateImage48 {
    /**
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int count = 0 ;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix.length ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp ;
            }
        }
        for(int[] row:matrix){
            reverse(row);
        }
    }

    void reverse(int[] arr){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ;
            left ++ ;
            right --;
        }
    }


    @Test
    public void test1() {
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(array);
        System.out.println("array=" + JsonUtil.toJson(array));
    }

}
