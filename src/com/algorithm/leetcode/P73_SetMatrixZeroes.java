package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class P73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length: 0;

        boolean zeroPresentInFirstRow = false;
        boolean zeroPresentInFirstColumn = false;

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(i == 0 && matrix[i][j] == 0) {
                    zeroPresentInFirstRow = true;
                }
                if(j == 0 && matrix[i][j] == 0) {
                    zeroPresentInFirstColumn = true;
                }
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i < m; i++) {
            for(int j=1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(zeroPresentInFirstRow) {
            setRowAsZero(matrix, 0, n);
        }

        if(zeroPresentInFirstColumn) {
            setColumnAsZero(matrix, 0, m);
        }
    }

    private void setColumnAsZero(int[][] matrix, int column, int m) {
        for(int i=0; i < m; i++) {
            matrix[i][column] = 0;
        }
    }

    private void setRowAsZero(int[][] matrix, int row, int n) {
        for(int j=0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }



    public static void main(String[] args) {
        P73_SetMatrixZeroes mainObject = new P73_SetMatrixZeroes();
        int[][] input1 = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        mainObject.setZeroes(input1);
        printMatrix(input1);
        System.out.println("----------------");
        int[][] input2 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        mainObject.setZeroes(input2);
        printMatrix(input2);
    }

    private static void printMatrix(int[][] input) {
        for(int i=0; i < input.length; i++) {
            for(int j=0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
