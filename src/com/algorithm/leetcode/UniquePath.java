package com.algorithm.leetcode;


/**
 * https://leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        if(m <=0 || n <= 0) {
            return 0;
        }
        int[][] table = new int[m][n];
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(i==0 || j == 0) {
                    table[i][j] = 1;
                    continue;
                }
                table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
        return table[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath mainObject = new UniquePath();
        System.out.println(mainObject.uniquePaths(3,2));
        System.out.println(mainObject.uniquePaths(7,3));
        System.out.println(mainObject.uniquePaths(3,1));
    }
}
