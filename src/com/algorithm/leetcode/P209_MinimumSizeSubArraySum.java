package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class P209_MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int minSize = Integer.MAX_VALUE;
        int startPosition = 0;
        int endPosition = 0;
        int sum = 0;

        while(true) {

            while(sum < s && endPosition < nums.length) {
                sum+= nums[endPosition];
                endPosition++;
            }

            if( sum >= s) {
                minSize = Math.min(minSize, endPosition - startPosition);
            }

            if(sum == s) {
                startPosition = startPosition+1;
                endPosition = startPosition;
                sum = 0;
                continue;
            }

            while(sum > s && startPosition < nums.length) {
                sum -= nums[startPosition];
                startPosition++;
                if(sum >= s) {
                    minSize = Math.min(minSize, endPosition - startPosition );
                }
            }

            if(sum == s) {
                startPosition = startPosition + 1;
                endPosition = startPosition;
                sum = 0;
                continue;
            }

            if(startPosition >= nums.length || endPosition >= nums.length) {
                break;
            }
        }

        minSize = minSize == Integer.MAX_VALUE ? 0: minSize;
        return minSize;
    }

    public static void main(String[] args) {
        P209_MinimumSizeSubArraySum mainObject = new P209_MinimumSizeSubArraySum();
        //int[] input = new int[]{2,3,1,2,4,3};int s =7;
        //int[] input = new int[]{1,4,4};int s=4;
        int[] input = new int[]{1,1};int s=3;
        //int[] input = new int[]{2,3,1,1,1,1,1};int s = 5;
        //int[] input = new int[]{1,2,3,4,5}; int s = 11;
        System.out.println(mainObject.minSubArrayLen(s, input));
    }
}
