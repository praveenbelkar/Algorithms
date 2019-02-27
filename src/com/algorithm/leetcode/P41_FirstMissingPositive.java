package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the smallest missing positive integer.
 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 */
public class P41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        int positiveNumbersInArray = 0;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] > 0) {
                positiveNumbersInArray++;
            }
        }
        if(positiveNumbersInArray == 0) {
            return 1;
        }
        //int sizeOfArray = nums.length;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        for(int i=0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int mod = nums[i] % positiveNumbersInArray;
                if (mod == 0) {
                    mod = positiveNumbersInArray;
                }
                int index = (mod) - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
        }

        int result = maxElement+1;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result = i;
                /*if(result == 0) {
                    result = 1;
                }
                }*/
                return result +1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P41_FirstMissingPositive mainObject = new P41_FirstMissingPositive();
        int nums[] = new int[]{2};//{7,8,9,11,12};//{3,4,-1,1};//{1,2,0};//
        System.out.println(mainObject.firstMissingPositive(nums));
    }
}
