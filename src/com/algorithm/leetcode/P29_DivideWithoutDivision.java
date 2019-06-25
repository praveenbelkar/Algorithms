package com.algorithm.leetcode;

import java.util.StringTokenizer;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Example1: Input: dividend = 10, divisor = 3 Output: 3
 * Example2: Input: dividend = 7, divisor = -3 Output: -2
 */

public class P29_DivideWithoutDivision {

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1) {
            return dividend*-1;
        }
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        int difference = absDividend - absDivisor;
        int count = 1;

        if( difference < 0) {
            return 0;
        }
        while(difference >= absDivisor) {
            difference = difference - absDivisor;
            if(difference > Integer.MAX_VALUE || difference < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            count++;
        }

        boolean dividendPositive = dividend < 0;
        boolean divisorPositive = divisor < 0;
        boolean resultPositive = !(dividendPositive ^ divisorPositive);
        if(!resultPositive) {
            count = count * -1;
        }
        if(count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return count;
    }

    public static void main(String[] args) {
        P29_DivideWithoutDivision mainObject = new P29_DivideWithoutDivision();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(mainObject.divide(dividend, divisor));


    }
}
