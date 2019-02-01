package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] matrix = new int[n][n];
        List<List<String>> results = new ArrayList<>();
        solveNQueensUtil(matrix,0, n, results);
        return results;
    }

    private void printMatrix(int[][] matrix) {
        System.out.println("-------------");
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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

    public static void main(String[] args) {
        NQueens mainObject = new NQueens();
        List<List<String>> results = mainObject.solveNQueens(4);
        for(List<String> result: results) {
            result.stream().forEach(System.out::println);
        }
    }
}
