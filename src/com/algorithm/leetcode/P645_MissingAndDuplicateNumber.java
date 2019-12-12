package com.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-mismatch/
 *
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 */
public class P645_MissingAndDuplicateNumber {

    public int[] findErrorNums(int[] nums) {
        if(null == nums || nums.length == 0) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int xor = 0;
        for(Integer element: nums) {
            set.add(element);
            sum = sum + element;
            xor = xor ^ element;
        }

        for(Integer element: set) {
            xor = xor ^ element;
        }

        int expectedSum = (nums.length * (nums.length + 1))/2;
        int missingNumber = (expectedSum - sum) + xor;
        int[] result = new int[2];
        result[0] = xor;
        result[1] = missingNumber;
        return result;
    }

    public static void main(String[] args) {
        P645_MissingAndDuplicateNumber mainObject = new P645_MissingAndDuplicateNumber();
        int[] nums = new int[]{1,2,2,4};
        int[] result = mainObject.findErrorNums(nums);
        for(Integer element: result) {
            System.out.println(element);
        }
    }
}
