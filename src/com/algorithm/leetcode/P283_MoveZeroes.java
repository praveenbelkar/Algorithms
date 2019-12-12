package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class P283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int positionOfNextNonZero = 0;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[positionOfNextNonZero] = nums[i];
                if(positionOfNextNonZero != i) {
                    nums[i] = 0;
                }
                positionOfNextNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        P283_MoveZeroes mainObject = new P283_MoveZeroes();
        int[] input = {0,1,0,3,12};
        int[] input2 = {1,3,0,0,0};

        mainObject.moveZeroes(input);
        for(Integer element: input) {
            System.out.print(element + " ");
        }
        System.out.println();

        mainObject.moveZeroes(input2);
        for(Integer element: input2) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
