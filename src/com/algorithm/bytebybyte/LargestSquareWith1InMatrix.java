package com.algorithm.bytebybyte;

import com.algorithm.praveen.arrays.LargeNumberAddition;

import java.util.Arrays;

/**
 * Given a 2-d array of 0 and 1, get the size of maximum square containing 1
 */
public class LargestSquareWith1InMatrix {

    public int largestSubSquare(int[][] input) {
        int[][] cache = new int[input.length][input[0].length];
        //Arrays.fill(cache, 0);
        int maxSquareSize = Integer.MIN_VALUE;
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[0].length; j++){
                if(i==0 || j==0) {
                    if(input[i][j]== 1) {
                        cache[i][j] = 1;
                    }
                    continue;
                }

                if(input[i][j] == 1) {
                    if(input[i][j-1] == 1 && input[i-1][j] == 1){
                        cache[i][j] = cache[i-1][j-1] + 1;
                        if(cache[i][j] > maxSquareSize) {
                            maxSquareSize = cache[i][j];
                        }
                    }
;                }
            }
        }
        return maxSquareSize;
    }

    public static void main(String[] args) {
        LargestSquareWith1InMatrix mainObject = new LargestSquareWith1InMatrix();
        int[][] input = {
                {0,0,1,1},
                {1,1,0,0},
                {1,1,0,0},
                {0,0,1,1}
        };
        System.out.println(mainObject.largestSubSquare(input));
    }
}
