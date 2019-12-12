package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class P51_NQueen {

    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) {
            return Collections.emptyList();
        }
        String[][] board = new String[n][n];
        board = initBoard(board);
        solveNQueens(board, 0);
        return convertArrayToListString(board);
    }

    private String[][] initBoard(String[][] board) {
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                board[i][j] = ".";
            }
        }
        return board;
    }

    private List<List<String>> convertArrayToListString(String[][] board) {
        List<String> result = new ArrayList<>();
        for(int i=0; i < board.length; i++) {
            String element = "";
            for(int j=0; j < board[0].length; j++) {
                element = element + board[i][j];
            }
            result.add(element);
        }
        List<List<String>> returnVal = new ArrayList<>();
        returnVal.add(result);
        return returnVal;
    }

    private boolean solveNQueens(String[][] board, int row) {
        int m = board.length;
        int n = board[0].length;
        if(row >= m ) {
            return false;
        }
        //for(int i=row; i < m; i++) {
        boolean solutionFound = false;
            for(int j = 0; j < n; j++) {
                board[row][j] = "Q";
                if(safe(board, row, j)) {
                    if(!solveNQueens(board, row+1)) {
                        board[row][j] = ".";
                        solutionFound = false;
                    } else {
                        solutionFound = true;
                    }
                } else {
                    board[row][j] = ".";
                }
            }
        //}
        return solutionFound;
    }

    private boolean safe(String[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        for(int i=row, j=0; j < col; j++) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        for(int i=0, j=col; i < row; i++) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        for(int i=row-1, j=col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        for(int i=row-1, j=col+1; i >= 0 && j <= n; i--, j++ ) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P51_NQueen mainObject = new P51_NQueen();
        List<List<String>> result = mainObject.solveNQueens(4);
        for(List<String> solution: result) {
            System.out.println("[");
            for(String element: solution) {
                System.out.println(element);
            }
            System.out.println("],");
        }
    }
}
