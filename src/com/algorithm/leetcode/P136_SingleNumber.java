package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 */
public class P136_SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        for(int i=1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        P136_SingleNumber mainObject = new P136_SingleNumber();
        int[] nums = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        System.out.println(mainObject.singleNumber(nums));
        System.out.println(mainObject.singleNumber(nums2));
    }
}
