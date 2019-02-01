package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 Example:
 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSumSubArray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int sumMax = nums[0];
        for(int i=1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            sumMax = Math.max(sumMax, maxSoFar);
            if(maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return sumMax;
    }

    public static void main(String[] args) {
        MaximumSumSubArray mainObject = new MaximumSumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-2,1};
        System.out.println(mainObject.maxSubArray(nums));
    }
}
