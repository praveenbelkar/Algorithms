package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/submissions/
 *
 * Given an array of integers arr and two integers k and threshold.
 *
 * Return the number of sub-arrays of size k and average greater than or equal to threshold.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
 * Example 2:
 *
 * Input: arr = [1,1,1,1,1], k = 1, threshold = 0
 * Output: 5
 * Example 3:
 *
 * Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 * Example 4:
 *
 * Input: arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * Output: 1
 * Example 5:
 *
 * Input: arr = [4,4,4,4], k = 4, threshold = 1
 * Output: 1
 */
public class P1343_NumberOfSubArraysGreaterThanAverage {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int avg = 0;
        int count = 0;
        avg = sum / k;
        for(int i=0; i < k; i++) {
            sum += arr[i];
        }

        avg = sum/k;
        if(avg >= threshold) {
            count++;
        }

        for(int i=k; i < arr.length; i++) {
            sum -= arr[i-k];
            sum += arr[i];
            avg = sum / k;
            if(avg >= threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        P1343_NumberOfSubArraysGreaterThanAverage mainObject = new P1343_NumberOfSubArraysGreaterThanAverage();
        int[] input = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;

        int result = mainObject.numOfSubarrays(input, k, threshold);
        System.out.println(result);
    }
}
