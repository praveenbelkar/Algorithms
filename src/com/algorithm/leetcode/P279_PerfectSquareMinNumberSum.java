package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class P279_PerfectSquareMinNumberSum {

    public int numSquares(int n) {
        int count = 0;
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return numSquaresUtil(n, cache);
    }

    private int numSquaresUtil1(int n, int[] cache) {

        if(cache[n] != -1) {
            return cache[n];
        }
        if(n == 0) {
            cache[0] = 1;
            return 1;
        }

        if(n==1) {
            cache[1] = 1;
            return 1;
        }

        if(isPerfectSquare(n)) {
            cache[n] = 1;
            return 1;
        }

        int minCount = Integer.MAX_VALUE;
        for(int i=1; i < n; i++) {
            if(isPerfectSquare(i)) {
                minCount = Math.min(numSquaresUtil(i, cache) + numSquaresUtil(n - i, cache), minCount);
            }
        }
        cache[n] = minCount;
        return cache[n];
    }

    private int numSquaresUtil(int n, int[] cache) {
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i <= n; i++) {
            int minVal = Integer.MAX_VALUE;
            if(isPerfectSquare(i)) {
                cache[i] = 1;
                continue;
            }
            for(int j=1; j < i; j++) {
                minVal = Math.min(cache[j] + cache[i-j], minVal);
            }
            cache[i] = minVal;
        }
        return cache[n];
    }

    private boolean isPerfectSquare(int num) {
        for(int i=1; i <= Math.sqrt(num); i++) {
            if(i*i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P279_PerfectSquareMinNumberSum mainObject = new P279_PerfectSquareMinNumberSum();
        System.out.println(mainObject.numSquares(11));
        System.out.println(mainObject.numSquares(12));
        System.out.println(mainObject.numSquares(13));
        System.out.println(mainObject.numSquares(6665));
    }

}
