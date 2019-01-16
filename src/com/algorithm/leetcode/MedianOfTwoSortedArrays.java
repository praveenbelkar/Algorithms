package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedian(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }

    private double findMedian(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
        return 0;
    }
}
