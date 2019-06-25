package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 */
public class P673_NumberOfLongestIncreasingSubsequenceLIS {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return lis(nums);
    }

    private int lis(int[] nums) {
        int[] lis = new int[nums.length];
        int[] trace = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            lis[i] = 1;
            trace[i]=-1;
        }
        int maxIndex = 0;

        int max = Integer.MIN_VALUE;
        for(int i=1; i < nums.length; i++) {
            int prev = 0;
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        prev = j;

                    }
                }
            }
            if(lis[i] > max) {
                max = lis[i];
                trace[i] = prev;
                maxIndex = i;
            }
        }

        for(int i=0; i < trace.length; i++) {
            System.out.print(" " + trace[i]);
        }
        System.out.println();
        System.out.println("maxIndex: " + maxIndex);

        int traceIndex = maxIndex;
        while(trace[traceIndex] != -1) {
            System.out.print(" " + nums[traceIndex]);
            traceIndex = trace[traceIndex];
        }
        System.out.print(" "+nums[traceIndex]);
        System.out.println();

        return max;
    }

    public static void main(String[] args) {
        P673_NumberOfLongestIncreasingSubsequenceLIS mainObject = new P673_NumberOfLongestIncreasingSubsequenceLIS();
        //int[] nums = {1,3,5,4,7};
        int[] nums = {1,1,1,1,1};
        System.out.println(mainObject.findNumberOfLIS(nums));
    }
}
