package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class P200_IslandCount {


    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid.length > 0 ? grid[0].length : 0;

        int[][] visited = new int[m][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    traverse(grid, visited, i, j);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void traverse(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;
        //check if its not last column
        if (j < grid[0].length - 1) {
            //if right cell is '1' and not visited
            if (grid[i][j + 1] == '1' && visited[i][j + 1] == 0) {
                traverse(grid, visited, i, j + 1);
            }
        }

        //Check if its not last row
        if (i < grid.length - 1) {
            //if bottom cell is '1' and not visited
            if (grid[i + 1][j] == '1' && visited[i + 1][j] == 0) {
                traverse(grid, visited, i + 1, j);
            }
        }

        //check if its not first column
        if(j-1 >= 0) {
            //if left cell is '1' and not visited
            if(grid[i][j-1] == '1' && visited[i][j-1] == 0) {
                traverse(grid, visited, i, j-1);
            }
        }

        //check if its not first row
        if(i-1 >= 0) {
            //if upper cell is '1' and not visited
            if(grid[i-1][j] == '1' && visited[i-1][j] == 0) {
                traverse(grid, visited, i-1, j);
            }
        }
    }

    public static void main(String[] args) {
        P200_IslandCount mainObject = new P200_IslandCount();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(mainObject.numIslands(grid));

        char[][] grid2 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(mainObject.numIslands(grid2));

        mainObject.numIslands(new char[][]{});

        char[][] grid3 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(mainObject.numIslands(grid3));

        char[][] grid4 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        System.out.println(mainObject.numIslands(grid4));

        char[][] grid5 = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}};

        System.out.println(mainObject.numIslands(grid5));
    }
}