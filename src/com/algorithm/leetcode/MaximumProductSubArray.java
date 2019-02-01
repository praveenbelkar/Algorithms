package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Example 1:

 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int currentMax = nums[0];
        int currentMin = nums[0];
        int productMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            int currentNumber = nums[i];
            if(currentNumber < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(currentNumber * currentMax, currentNumber);
            currentMin = Math.min(currentNumber * currentMin, currentNumber);

            productMax = Math.max(productMax, currentMax);
        }
        return productMax;
    }

    public static void main(String[] args) {
        MaximumProductSubArray mainObject = new MaximumProductSubArray();
        int[] nums = {-2, -3, -1, 10};//{2,3,-2,4};
        System.out.println(mainObject.maxProduct(nums));
    }
}
