package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class P79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if(null == word || word.trim().length() ==0 ) {
            return false;
        }
        int m = board.length;
        int n = m > 0 ? board[0].length: 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int currentWordPosition, boolean[][] visited) {
        int m = board.length;
        int n = m > 0 ? board[0].length: 0;

        if(i >= m || j >= n || i < 0 || j < 0 || visited[i][j] == true) {
            return false;
        }
        if(currentWordPosition == word.length()-1 && board[i][j] == word.charAt(currentWordPosition)) {
            return true;
        }

        if(board[i][j] != word.charAt(currentWordPosition)) {
            return false;
        }

        visited[i][j] = true;
        if(board[i][j] == word.charAt(currentWordPosition) && (
                   dfs(board, word, i, j+1, currentWordPosition+1, visited)
                || dfs(board, word, i+1, j, currentWordPosition + 1, visited)
                || dfs(board, word, i, j-1, currentWordPosition + 1, visited)
                || dfs(board, word, i-1, j, currentWordPosition + 1, visited))) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        P79_WordSearch mainObject = new P79_WordSearch();
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(mainObject.exist(board, "ABCCED"));
        System.out.println(mainObject.exist(board, "SEE"));
        System.out.println(mainObject.exist(board, "ABCB"));
        System.out.println(mainObject.exist(board, "X"));
        System.out.println(mainObject.exist(board, ""));
        System.out.println(mainObject.exist(new char[][]{}, "ABC"));
    }
}
