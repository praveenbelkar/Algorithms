package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class P560_SubArraySum {

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i < nums.length; i++) {
            sum = sum + nums[i];
            count = count + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        P560_SubArraySum mainObject = new P560_SubArraySum();
        int[] nums1 = {1,2,3,2,1};
        System.out.println(mainObject.subarraySum(nums1,5));

        int[] nums2 = {1,1,1};
        System.out.println(mainObject.subarraySum(nums2,2));

        int[] nums3 = {-1,-1,1};
        System.out.println(mainObject.subarraySum(nums3,0));

    }
}
