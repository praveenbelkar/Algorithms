package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 */
public class ReverseInteger {

    public int reverse(int x) {

        if(x == 1534236469) {
            System.out.println("hi");
        }
        if(x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }

        //Remove trailing zeroes
        int remainder = x % 10;
        while(remainder == 0) {
            x = x / 10;
            remainder = x % 10;
        }

        //String input = String.valueOf(x);
        boolean isPositive = x > 0 ? true: false;
        x = Math.abs(x);
        int result = 0;
        int prevResult = 0;
        while(x > 0) {
            remainder = x % 10;
            result = prevResult*10 + remainder;
            if(overflowing(result, prevResult)) {
                return 0;
            }
            x = x/10;
            prevResult = result;
        }
        result = isPositive ? result : result*-1;
        return result;
    }

    private boolean overflowing(int result, int prevResult) {
        return result/10 != prevResult;
    }

    public static void main(String[] args) {
        ReverseInteger mainObject = new ReverseInteger();
        int input = 123;
        int result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);

        input = -123;
        result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);

        input = 1200;
        result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);

        input = Integer.MIN_VALUE;
        result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);

        input = Integer.MAX_VALUE;
        result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);

        input = 1534236469;
        result = mainObject.reverse(input);
        System.out.println("input: " + input + " result: " + result);


    }
}
