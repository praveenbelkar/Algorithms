package com.algorithm.praveen.arrays;

import java.util.Arrays;

/**
 * Given two large numbers as string, calculate their sum
 * e.g. x="442678245", y="85628415", sum = "528306660"
 */
public class LargeNumberAddition {

    public String addLargeNumbers(String number1, String number2) {
        int[] input1 = convertStringToArray(number1);
        int[] input2 = convertStringToArray(number2);
        int[] result = new int[Math.max(input1.length, input2.length) + 1];

        int index1 = input1.length - 1;
        int index2 = input2.length - 1;
        int resultIndex = result.length - 1;
        int carry = 0;
        int sum = 0;

        while(index1 >=0 && index2 >= 0) {
            sum = input1[index1--] + input2[index2--] + carry;
            carry = sum / 10;
            sum = sum % 10;
            result[resultIndex--] = sum;
        }

        while(index1 >= 0) {
            sum = input1[index1--] + carry;
            carry = sum / 10;
            sum = sum % 10;
            result[resultIndex--] = sum;
        }

        while(index2 >= 0) {
            sum = input2[index2--] + carry;
            carry = sum / 10;
            sum = sum % 10;
            result[resultIndex--] = sum;
        }

        if(carry > 0) {
            result[resultIndex] = carry;
        }

        return convertArrayToString(result);
    }

    private int[] convertStringToArray(String number) {
        int[] input = new int[number.length()];
        for(int i=0; i<number.length(); i++) {
            input[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return input;
    }

    private String convertArrayToString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            if(i==0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargeNumberAddition mainObject = new LargeNumberAddition();
        String number1 = "1234";
        String number2 =  "982";
        System.out.println(mainObject.addLargeNumbers(number1, number2)); // 2216
    }
}
