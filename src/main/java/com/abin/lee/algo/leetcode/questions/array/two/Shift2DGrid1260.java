package com.abin.lee.algo.leetcode.questions.array.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode.cn/problems/shift-2d-grid/description/
 */
public class Shift2DGrid1260 {
    /**
     * 1260. 二维网格迁移
     * //用一个index表示一维下标，row = index / n,col = index % n;
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j <n ; j++) {
                part.add(0);
            }
            result.add(part) ;
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                int index = (i*n+j+k)%(m*n) ;
                result.get(index/n).set(index%n, grid[i][j]);
            }
        }
        return result;
    }

}
