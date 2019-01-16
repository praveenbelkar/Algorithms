package com.algorithm.bytebybyte;

import java.util.Arrays;

/**
 * https://www.byte-by-byte.com/matrixproduct
 *
 * Given a matrix, find the path fron top left to bottom right with the greatest product by moving
 * only down and right
 *
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 * 1->4->7->8->9 = 2016
 *
 * [-1,2,3]
 * [4,5,-6]
 * [7,8,9]
 * -1 -> 4 -> 5 -> -6 ->9 = 1080
 */
public class MatrixProduct {

    public int matrixProductRecursive(int[][] input, int i, int j) {
        if(i == 0 && j == 0) {
            return input[i][j];
        }
        if(i == 0) {
            return input[i][j] * matrixProductRecursive(input, i, j-1);
        } else if(j == 0){
            return input[i][j] * matrixProductRecursive(input, i-1, j);
        } else {
          return Math.max( input[i][j] * matrixProductRecursive(input, i-1, j),
                  input[i][j] * matrixProductRecursive(input, i, j-1));
        }
    }

    public int matrixProductDp(int[][] input) {
        int[][] cache = new int[input.length][input[0].length];
        for(int i=0; i < input.length; i++){
            for(int j=0; j < input[0].length; j++) {
                if(i==0 && j==0){
                    cache[i][j] = input[i][j];
                }else if(i==0){
                    cache[i][j] = input[i][j] * cache[i][j-1];
                }else if(j==0){
                    cache[i][j] = input[i][j] * cache[i-1][j];
                }else{
                    cache[i][j] = Math.max(input[i][j] * cache[i-1][j], input[i][j] * cache[i][j-1]);
                }
            }
        }

        for(int i=0; i<cache.length; i++){
            for(int j=0; j<cache[0].length; j++){
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        return cache[input.length-1][input[0].length-1];
    }

    public static void main(String[] args) {
        MatrixProduct mainObject = new MatrixProduct();
        int[][] input = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] input2 = {
                {-1,2,3},
                {4,5,-6},
                {7,8,9}
        };
        System.out.println(mainObject.matrixProductRecursive(input, input.length-1, input[0].length-1));
        System.out.println(mainObject.matrixProductRecursive(input2, input2.length-1, input2[0].length-1));

        System.out.println(mainObject.matrixProductDp(input));
        System.out.println(mainObject.matrixProductDp(input2));

    }
}
