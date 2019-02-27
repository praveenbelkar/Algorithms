package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 Example 1:
 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 */
public class P189_RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }

        if(k > nums.length) {
            k = k % nums.length;
        }

        if(k == 0) {
            return;
        }

        int position = (nums.length-1) - k;
        reverse(nums, 0, position);
        reverse(nums, position + 1, nums.length-1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for(int i=start, j=end; i <= j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        P189_RotateArray mainObject = new P189_RotateArray();
        int[] input = {1,2,3,4,5,6,7};
        int k = 10;
        mainObject.rotate(input, k);
        Arrays.stream(input).forEach(element -> System.out.print(element + " "));
    }
}
