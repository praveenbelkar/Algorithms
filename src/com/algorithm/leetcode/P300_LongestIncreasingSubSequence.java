package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class P300_LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }

        int[] table = new int[nums.length];
        int longestSequence = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            table[i] = 1;
        }

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
            longestSequence = Math.max(longestSequence, table[i]);
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        P300_LongestIncreasingSubSequence mainObject = new P300_LongestIncreasingSubSequence();
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        //int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        //int[] nums = new int[]{2,2};
        int[] nums = new int[]{0};
        System.out.println(mainObject.lengthOfLIS(nums));
    }
}
