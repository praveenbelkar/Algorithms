package com.algorithm.bytebybyte;

import java.util.Arrays;

/**
 * https://www.byte-by-byte.com/zeromatrix
 * Given a boolean matrix, update it so that if any cell is true,
 * all the cells in that row and column are true.
 *
 *
 [true,  false, false]      [true,  true,  true ]
 [false, false, false]  ->  [true,  false, false]
 [false, false, false]      [true,  false, false]
 */
public class ZeroMatrix {

    public boolean[][] zeroMatrix(boolean[][] input){
        boolean[][] result = new boolean[input.length][input[0].length];
        //Arrays.fill(result, false);
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[0].length; j++){
                if(input[i][j]){
                    updateRowAndColumn(result, i, j);
                }
            }
        }
        return result;
    }

    private void updateRowAndColumn(boolean[][] result, int row, int column) {
        updateRow(result, row);
        updateColumn(result, column);
    }

    private void updateColumn(boolean[][] result, int column) {
        for(int i=0; i<result.length; i++){
            result[i][column] = true;
        }
    }

    private void updateRow(boolean[][] result, int row) {
        for(int j=0; j<result[0].length; j++){
            result[row][j] = true;
        }
    }

    public static void main(String[] args) {
        ZeroMatrix mainObject = new ZeroMatrix();
        boolean[][] input = {
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };

        boolean[][] result = mainObject.zeroMatrix(input);
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
