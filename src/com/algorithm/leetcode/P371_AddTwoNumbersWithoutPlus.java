package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class P371_AddTwoNumbersWithoutPlus {

    public int getSum(int a, int b) {
        int lsb1 = 0;
        int lsb2 = 0;
        int bitResult = 0;
        int result = 0;
        int carry = 0;

        int i=0;
        String temp = null;
        while(a > 0 || b > 0) {
            temp = Integer.toBinaryString(a);
            temp = Integer.toBinaryString(b);

            lsb1 = a & 1;
            lsb2 = b & 1;

            bitResult = lsb1 ^ lsb2 ;
            bitResult = bitResult ^ carry;
            carry = getCarry(lsb1, lsb2, carry);
            bitResult = bitResult << i;
            i++;
            result = result | bitResult;
            temp = Integer.toBinaryString(result);
            a = a >> 1;
            b = b >> 1;
        }

        if(carry > 0) {
            carry = carry << i;
            result = result | carry;
        }
        temp = Integer.toBinaryString(result);
        return result;
    }

    private int getCarry(int lsb1, int lsb2, int carry) {
        if ((lsb1 == 1 && lsb2 == 1 && carry == 1)
        || (lsb1 == 1 && lsb2 == 1 && carry == 0)
        || (lsb1 == 0 && lsb2 == 1 && carry == 1)
        || (lsb1 == 1 && lsb2 == 0 && carry == 1)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P371_AddTwoNumbersWithoutPlus().getSum(21,15));
    }
}
