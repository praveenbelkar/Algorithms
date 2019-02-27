package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number/
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 */
public class P268_MissingNumber {

    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int actualSum = 0;
        actualSum = Arrays.stream(nums).sum();
        int expectedSum = nums.length * (nums.length +1)/2;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        P268_MissingNumber mainObject = new P268_MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(mainObject.missingNumber(nums));
    }
}
