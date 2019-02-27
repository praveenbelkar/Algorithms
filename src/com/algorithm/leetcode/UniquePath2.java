package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || obstacleGrid.length <=0 || obstacleGrid[0].length <= 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] table = new int[m][n];

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
               if(obstacleGrid[i][j] == 1 ) {
                   table[i][j] = 0;
               } else {
                   if(i == 0 && j == 0){
                       table[i][j] = (obstacleGrid[i][j] == 1 ? 0: 1);
                       continue;
                   }
                   if(i == 0) {
                       table[i][j] = table[i][j-1];
                       continue;
                   }
                   if(j == 0) {
                       table[i][j] = table[i-1][j];
                       continue;
                   }
                   table[i][j] = table[i-1][j] + table[i][j-1];
               }
            }
        }
        return table[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath2 mainObject = new UniquePath2();
        int[][] obstacleGrid = {
                /*{0,1,0},
                {0,1,0},
                {0,0,0}*/
        };
        System.out.println(mainObject.uniquePathsWithObstacles(obstacleGrid));
    }
}
