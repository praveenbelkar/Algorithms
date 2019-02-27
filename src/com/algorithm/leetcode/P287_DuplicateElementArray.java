package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate
 * number, find the duplicate one.

 Example 1:

 Input: [1,3,4,2,2]
 Output: 2
 Example 2:

 Input: [3,1,3,4,2]
 Output: 3
 */
public class P287_DuplicateElementArray {

    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 0;
        int duplicate = 0;
        for(int i=0; i < nums.length; i++) {
            temp = nums[Math.abs(nums[i])-1];
            if(temp < 0) {
                duplicate = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])-1] = -temp;
        }

        for(int i=0; i < nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] = nums[i] * -1;
            }
        }
        return duplicate;
    }

    public static void main(String[] args) {
        P287_DuplicateElementArray mainObject = new P287_DuplicateElementArray();
        //int[] nums = {1,3,4,2,2};
        int[] nums = {3,1,3,4,2};
        System.out.println(mainObject.findDuplicate(nums));
    }
}
