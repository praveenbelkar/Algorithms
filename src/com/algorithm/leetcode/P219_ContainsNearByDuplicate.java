package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 Example 1:
 Input: nums = [1,2,3,1], k = 3
 Output: true
 */
public class P219_ContainsNearByDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(countMap.containsKey(nums[i])) {
                int numIndex = countMap.get(nums[i]);
                if( (i - numIndex) <= k) {
                    return true;
                }
            }
            countMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        P219_ContainsNearByDuplicate mainObject = new P219_ContainsNearByDuplicate();
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(mainObject.containsNearbyDuplicate(nums, k));
    }
}
