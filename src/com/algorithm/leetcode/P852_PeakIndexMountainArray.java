package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:

 Input: [0,1,0]
 Output: 1
 Example 2:

 Input: [0,2,1,0]
 Output: 1
 */
public class P852_PeakIndexMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        if(null == A || A.length == 0) {
            return -1;
        }

        int low=0, mid=0, high=A.length-1;
        while(low <= high) {
            mid = low + (high - low)/2;
            if( (mid > 0 && A[mid] > A[mid-1]) && (mid < A.length - 1 && A[mid] > A[mid+1])) {
                return mid;
            }
            if( mid > 0 && A[mid] > A[mid-1]) {
                low = mid + 1;
            } else if( mid < A.length - 1 && A[mid] > A[mid+1]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        P852_PeakIndexMountainArray mainObject = new P852_PeakIndexMountainArray();
        int[] nums = {0,1,0};
        System.out.println(mainObject.peakIndexInMountainArray(nums));
    }
}
