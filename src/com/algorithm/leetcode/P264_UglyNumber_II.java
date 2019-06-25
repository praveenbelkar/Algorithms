package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 */
public class P264_UglyNumber_II {

    public int nthUglyNumber(int n) {
        int cnt = 1;
        int i = 2;
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        while (cnt < n) {
            if(isUglyNumber(i, cache)) {
                cnt++;
            }
            i++;
        }
        return --i;
    }

    private boolean isUglyNumber(int num, int[] cache) {
        if(num == 2 || num == 3 || num == 5) {
            return true;
        }
        if(cache[num] != -1) {
            return cache[num] == 1 ? true: false;
        }

        if( (isDivisible(num,2) && isUglyNumber(num/2, cache)) || (isDivisible(num,3) && isUglyNumber(num/3, cache)) || ((isDivisible(num,5) && isUglyNumber(num/5, cache)))) {
            cache[num] = 1;
            return true;
        }

        cache[num] = 0;
        return false;
    }

    private boolean isDivisible(int num, int i) {
        return num % i == 0;
    }

    public static void main(String[] args) {
        P264_UglyNumber_II mainObject = new P264_UglyNumber_II();
        System.out.println(mainObject.nthUglyNumber(10));
    }
}
