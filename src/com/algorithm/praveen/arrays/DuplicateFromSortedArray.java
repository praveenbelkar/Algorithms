package com.algorithm.praveen.arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * 
 * Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
 */

public class DuplicateFromSortedArray {
    public static int removeElement(int[] nums, int val) {
        int position = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[position++] = nums[i];
            }
        }
        return position;
    }

    public static void main(String args[]) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int position = removeElement(nums, 2);
        System.out.print(position + " position ");
        for(int i =0; i<position; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
    }
}