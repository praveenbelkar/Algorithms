package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/sqrtx/
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class P69_SquareRoot {

    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        Integer ix = new Integer(x);
        Long longX = ix.longValue();
        Long i = 0L;
        Long product = 1L;
        for(i=1L; i < longX; i++) {
            product = i*i;
            if(product < x) {
                continue;
            }
            if(product == x) {
                return i.intValue();
            }
            return i.intValue() - 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        P69_SquareRoot mainObject = new P69_SquareRoot();
        System.out.println(mainObject.mySqrt(8));
        System.out.println(mainObject.mySqrt(9));
        System.out.println(mainObject.mySqrt(2147483647));
    }
}
