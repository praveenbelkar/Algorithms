package com.algorithm.leetcode;

/**
 * Given a 2-d array of 0 and 1, get the size of maximum square containing 1
 */
public class LargestSquareWith1InMatrix {

    public int maximalSquare(char[][] charInput) {
        if(null == charInput || charInput.length == 0 || charInput[0].length == 0) {
            return 0;
        }
        int[][] input = getIntInput(charInput);
        int[][] cache = new int[input.length][input[0].length];
        int maxSquareSize = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;
        int area = 0;
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[0].length; j++){
                if(i==0 || j==0) {
                    if(input[i][j]== 1) {
                        cache[i][j] = 1;
                        maxArea = Math.max(maxArea, 1);
                    } else {
                        maxArea = Math.max(maxArea, 0);
                    }
                    continue;
                }

                if(input[i][j] == 1) {
                    if(input[i][j-1] == 1 && input[i-1][j] == 1){
                        int x = Math.min(cache[i-1][j-1], cache[i-1][j]);
                        int y = Math.min(cache[i][j-1], x);
                        cache[i][j] = y + 1;
                        if(cache[i][j] > maxSquareSize) {
                            maxSquareSize = cache[i][j];
                            area = maxSquareSize * maxSquareSize;
                            maxArea = Math.max(area, maxArea);
                        }
                    } else {
                        cache[i][j] = 1;
                    }
                }
            }
        }
        return maxArea;
    }

    private int[][] getIntInput(char[][] charInput) {
        int[][] input = new int[charInput.length][charInput[0].length];
        for(int i=0; i<charInput.length; i++) {
            for(int j=0; j<charInput[0].length; j++) {
                input[i][j] = charInput[i][j] == '0' ? 0 : 1 ;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        LargestSquareWith1InMatrix mainObject = new LargestSquareWith1InMatrix();
        char[][] input = new char[][]{
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        /*char[][] input = {
                {'0'}
        };*/
        System.out.println(mainObject.maximalSquare(input));
    }
}
