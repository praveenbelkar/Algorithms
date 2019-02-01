package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Input: [1,2,3]
 Output: [1,2,4]
 */
public class OnePlus {

    public int[] plusOne(int[] digits) {
        int[] output;
        if(allDigitsAre9(digits)) {
            output = new int[digits.length + 1];
        } else {
            output = new int[digits.length];
        }

        int carry = 1;
        int inputIndex = digits.length - 1;
        int outputIndex = output.length - 1;
        while(outputIndex >= 0) {
            int currentDigit = 0;
            if(inputIndex < 0) {
                currentDigit = 0;
            } else {
                currentDigit = digits[inputIndex];
            }
            if (carry == 1) {
                int sum = currentDigit + carry;
                int remainder = sum % 10;
                carry = sum / 10;
                output[outputIndex] = remainder;
                outputIndex--;
                inputIndex--;

            } else {
                output[outputIndex] = currentDigit;
                outputIndex--;
                inputIndex--;
            }
        }
        return output;
    }

    private boolean allDigitsAre9(int[] digits) {
        long non9Digits = Arrays.stream(digits).filter(digit -> digit != 9).count();
        return non9Digits > 0 ? false: true;
    }

    public static void main(String[] args) {
        OnePlus mainObject = new OnePlus();
        int[] input = {9,9,9};
        int[] output = mainObject.plusOne(input);
        Arrays.stream(output).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
