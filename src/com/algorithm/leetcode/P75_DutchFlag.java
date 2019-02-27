package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 */
public class P75_DutchFlag {
    public void sortColors(int[] nums) {
        int low=0, mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }

        for(Integer element: nums) {
            System.out.print(element + " ");
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void main(String[] args) {
        P75_DutchFlag mainObject = new P75_DutchFlag();
        int[] nums = {2,0,2,1,1,0};
        //int[] nums = {2,0,1};
        mainObject.sortColors(nums);
    }
}
