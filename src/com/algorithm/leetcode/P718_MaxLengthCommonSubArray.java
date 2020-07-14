package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */
public class P718_MaxLengthCommonSubArray {

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m][n];
        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i < m; i++) {
            if(B[0] == A[i]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for(int i=0; i < n; i++) {
            if(B[i] == A[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for(int i=1; i < m; i++) {

            for(int j=1; j < n; j++) {
                if(B[i] == A[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                } else {
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        P718_MaxLengthCommonSubArray mainObject = new P718_MaxLengthCommonSubArray();
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(mainObject.findLength(A, B));
    }
}
