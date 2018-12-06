package com.algorithm.praveen.dynamicprogram;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a set of numbers returns true if there is a sub-set whose sum equals to the given input
 */
public class SumSubSet {

    public boolean subsetContainsSum(int sum, int n, int[] set) {
        boolean[][] cache = new boolean[sum+1][n+1];
        for(int i = 0; i <= sum; i++) {
            for(int j = 0; j <= n; j++) {
                cache[i][j] = false;
            }
        }

        for(int i=0; i <= sum; i++) {
            for(int j=0; j <= n; j++) {
                //Sum has become 0, while there are still some coins left
                if(i == 0 && j >= 0) {
                    cache[i][j] = true;
                    continue;
                }

                //Sum has not yet become 0, and all coins are over
                if(i > 0 && j == 0) {
                    cache[i][j] = false;
                    continue;
                }

                //Current coin is greater than the sum, then exclude that coin
                if(set[j-1] > i) {
                    cache[i][j] = cache[i][j-1];
                } else { //
                    cache[i][j] = cache[i][j-1] || cache[i - set[j-1]][j-1];
                }
            }
        }

        return cache[sum][n];
    }

    public static void main(String[] args) {
        SumSubSet mainObject = new SumSubSet();
        int[] set = {2,3,7,8,10};
        int sum = 11;
        System.out.println(mainObject.subsetContainsSum(sum, set.length, set));
    }
}
