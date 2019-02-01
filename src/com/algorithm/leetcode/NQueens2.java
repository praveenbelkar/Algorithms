package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens-ii/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class NQueens2 {
    public int totalNQueens(int n) {
        int[][] matrix = new int[n][n];
        List<List<String>> results = new ArrayList<>();
        solveNQueensUtil(matrix,0, n, results);
        return results.size();
    }

    private boolean solveNQueensUtil(int[][] matrix, int col, int n, List<List<String>> results) {
        if(col >= n) {
            //printMatrix(matrix);
            List<String> result = convertMatrixToString(matrix);
            results.add(result);
            return true;
        }

        boolean solutionFound = false;
        for(int i=0; i<n; i++) {
            if(isSafe(matrix, i, col)) {
                matrix[i][col] = 1;
                if(solveNQueensUtil(matrix, col+1, n, results)){
                    solutionFound = true;
                }
                matrix[i][col] = 0;
            }
        }
        return solutionFound;
    }

    private boolean isSafe(int[][] matrix, int rowPosition, int colPosition) {
        int row = matrix.length;
        int column = matrix[0].length;
        //Check row
        for(int j=0; j < colPosition; j++) {
            if(matrix[rowPosition][j] == 1) {
                return false;
            }
        }

        //Check upper diagonal
        for(int i=rowPosition, j=colPosition;;) {
            if(matrix[i][j] == 1) {
                return false;
            }
            i--;
            j--;
            if(i < 0 || j < 0){
                break;
            }
        }

        //Check lower diagonal
        for(int i=rowPosition, j=colPosition;;) {
            if(matrix[i][j] == 1) {
                return false;
            }
            i++;
            j--;
            if(i >= row || j < 0){
                break;
            }
        }

        return true;
    }

    private List<String> convertMatrixToString(int[][] matrix) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<matrix[0].length; j++) {
                sb.append(matrix[i][j] == 1 ? "Q":".");
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens2 mainObject = new NQueens2();
        int results = mainObject.totalNQueens(4);
        System.out.println(results);
    }
}
