package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class P289_GameOfLife_BoardGame {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board.length > 0 ? board[0].length: 0;

        //int[][] newBoard = new int[m][n];
        int[][] aliveNeighbourBoard = new int[m][n];

        countAliveNeighbours(board, aliveNeighbourBoard);
        printMatrix(aliveNeighbourBoard);
        System.out.println("---------------------");
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(board[i][j] == 0) {
                    handleZero(board, aliveNeighbourBoard,  i, j);
                } else {
                    handleOne(board, aliveNeighbourBoard, i, j);
                }
            }
        }
    }

    private void handleOne(int[][] board, int[][] aliveNeighbourBoard, int i, int j) {
        if(aliveNeighbourBoard[i][j] < 2 || aliveNeighbourBoard[i][j] > 3) {
            board[i][j] = 0;
        }
    }

    private void handleZero(int[][] board, int[][] aliveNeighbourBoard, int i, int j) {
        if(aliveNeighbourBoard[i][j] == 3) {
            board[i][j] = 1;
        }
    }

    private void countAliveNeighbours(int[][] board, int[][] aliveNeighbourBoard) {
        int m = aliveNeighbourBoard.length;
        int n = m > 0 ? aliveNeighbourBoard[0].length : 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int aliveNeighbours = 0;
                //North-West
                if(!(j == 0 || i == 0)) {
                    if(board[i-1][j-1] == 1) {
                        aliveNeighbours++;
                    }
                }

                //North
                if( !(i == 0)) {
                    if(board[i-1][j] == 1) {
                        aliveNeighbours++;
                    }
                }

                //North-East
                if( !(j == n-1 || i == 0) ) {
                    if(board[i-1][j+1] == 1) {
                        aliveNeighbours++;
                    }
                }

                // West
                if( !(j == 0)) {
                    if(board[i][j-1] == 1) {
                        aliveNeighbours++;
                    }
                }

                //East
                if( !(j == n-1)) {
                    if(board[i][j+1] == 1) {
                        aliveNeighbours++;
                    }
                }

                //South-West
                if( !(i == m-1 || j == 0)) {
                    if(board[i+1][j-1] == 1) {
                        aliveNeighbours++;
                    }
                }

                //South
                if( !(i == m-1)) {
                    if(board[i+1][j] == 1) {
                        aliveNeighbours++;
                    }
                }

                //South-East
                if( !(i == m-1 || j == n-1)) {
                    if(board[i+1][j+1] == 1) {
                        aliveNeighbours++;
                    }
                }

                aliveNeighbourBoard[i][j] = aliveNeighbours;
            }
        }
    }

    public static void main(String[] args) {
        P289_GameOfLife_BoardGame mainObject = new P289_GameOfLife_BoardGame();
        int[][] input = {
                {1,1,1},
                {0,0,1},
                {1,1,1},
                {0,0,0}};

        mainObject.gameOfLife(input);

        printMatrix(input);
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
