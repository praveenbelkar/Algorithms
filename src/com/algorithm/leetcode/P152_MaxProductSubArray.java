package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class P152_MaxProductSubArray {

    public int maxProduct(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int m = nums.length;
        int[] table = new int[m];
        int maxProduct = Integer.MIN_VALUE;

        for(int i=0; i < nums.length; i++) {
            table[i] = nums[i];
            maxProduct = Math.max(maxProduct, table[i]);
        }

        for(int i=1; i < nums.length; i++) {
            table[i] = Math.max(table[i], table[i-1]*table[i]);
            maxProduct = Math.max(maxProduct, table[i]);
        }
        return maxProduct;
    }

    public int maxProduct1(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int m = nums.length;
        int[][] table = new int[m][m];
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            table[i][i] = nums[i];
            maxProduct = Math.max(maxProduct, table[i][i]);
        }

        for(int end=0; end < m; end++) {
            for(int start=0; start <= end; start++) {
                if(end==start) {
                    table[end][start] = nums[start];
                    continue;
                }

                table[end][start] = table[end-1][start] * nums[end];
                maxProduct = Math.max(maxProduct, table[end][start]);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        P152_MaxProductSubArray mainObject = new P152_MaxProductSubArray();
        //int[] nums = new int[]{2,3,-2,4};
        //int[] nums = new int[]{-2,0,-1};
        //int[] nums = new int[]{0,2};
        int[] nums = new int[]{-2, 3, -4};
        System.out.println(mainObject.maxProduct(nums));
    }
}
