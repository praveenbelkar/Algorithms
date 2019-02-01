package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 */
public class DegreeOfArray {

    private static class Info {
        public int startIndex;
        public int endIndex;
        public int count;
    }

    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        List<Info> mostFrequentElementsList = new ArrayList<>();
        Map<Integer, Info> map = new HashMap<>();
        int highestFrequency = 0;
        Info mostFrequentElement = null;
        for(int i=0; i<nums.length; i++) {
            Integer currentNumber = nums[i];
            Info element = new Info();
            if(map.containsKey(nums[i])) {
              element = map.get(currentNumber);
              element.endIndex = i;
              element.count = element.count + 1;
            } else {
                element.startIndex = i;
                element.endIndex = i;
                element.count  = 1;
            }
            map.put(currentNumber, element);
            if(highestFrequency <= element.count) {
                highestFrequency = element.count;
                mostFrequentElement = element;
            }

        }

        return calculateMinRange(map, highestFrequency);
    }

    private int calculateMinRange(Map<Integer, Info> map, int highestFrequency) {
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Info> entry: map.entrySet()) {
            if(entry.getValue().count == highestFrequency) {
                result = Math.min(result, entry.getValue().endIndex - entry.getValue().startIndex + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DegreeOfArray mainObject = new DegreeOfArray();
        int[] nums = {2,1,1,2,1,3,3,3,1,3,1,3,2};//{1,2,2,3,1,4,2};//{1, 2, 2, 3, 1};
        System.out.println(mainObject.findShortestSubArray(nums));
    }
}
