package com.algorithm.bytebybyte;

/**
 * https://www.byte-by-byte.com/matrixsearch
 * Given an n x m array where all rows and columns are in sorted order,
 * write a function to determine whether the array contains an element x.
 */
public class SortedMatrixSearch {

    public void search(int[][] matrix, int key) {
        int maxRow = matrix.length-1;
        int maxColumn = matrix[0].length-1;
        int i=0;
        int j=maxColumn;
        while(i <= maxRow && j >= 0){
            if(key == matrix[i][j]){
                System.out.println("element found at " + (i+1) + " row and " + (j+1) + " column");
                return;
            }else if(key > matrix[i][j]){
                i++;
            }else { //key < matrix[i][j]
                j--;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        SortedMatrixSearch mainObject = new SortedMatrixSearch();
        int[][] input = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int key = 10;

        mainObject.search(input, key);
    }
}
