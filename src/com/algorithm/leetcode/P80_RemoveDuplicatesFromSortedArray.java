package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * iven a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class P80_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int pos=0;
        int cnt = 1;

        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }

        for(int i=1; i < nums.length; i++) {
            int toBeCompared = nums[pos];
            while(i < nums.length && nums[i] == toBeCompared) {
                if(cnt < 2) {
                    pos++;
                    cnt++;
                }
                i++;
            }

            cnt = 1;
            if(pos >= nums.length) {
                return pos;
            }
            if(i < nums.length) {
                nums[pos] = nums[i];
                pos++;
            } else {
                nums[pos] = nums[i-1];
            }

        }
        for(int i=0; i < pos; i++)     {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return pos;
    }

    public static void main(String[] args) {
        P80_RemoveDuplicatesFromSortedArray mainObject = new P80_RemoveDuplicatesFromSortedArray();
        int[] input = {1,1,1,2,2,3};
        //System.out.println(mainObject.removeDuplicates(input));

        System.out.println();
        int[] input1 = {0,0,1,1,1,1,2,3,3};
        for(Integer element: input1) {
            System.out.print(element + " ");
        }
        System.out.println();
        //System.out.println(mainObject.removeDuplicates(input1));
        int[] input3 = {};
        //System.out.println(mainObject.removeDuplicates(input3));

        int[] input4 = {1,1};
        //System.out.println(mainObject.removeDuplicates(input4));

        int[] input5 = {1,2,2};
        System.out.println(mainObject.removeDuplicates(input5));
    }
}
