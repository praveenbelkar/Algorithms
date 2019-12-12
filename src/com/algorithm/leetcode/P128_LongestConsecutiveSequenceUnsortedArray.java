package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers, find the length of the longest
 consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3,
 4]. Therefore its length is 4.
 */
public class P128_LongestConsecutiveSequenceUnsortedArray {


    public int longestConsecutive(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            visitedMap.put(nums[i], false);
        }

        int largestConsequetive = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            int consecutivesForCurrentElement = 0;
            //visitedMap.put(nums[i], true);
            consecutivesForCurrentElement =
                    checkIfConsecutivesPresent(nums[i], nums,visitedMap);
            largestConsequetive =
                    Math.max(largestConsequetive,consecutivesForCurrentElement);
        }
        return largestConsequetive;
    }

    private int checkIfConsecutivesPresent(int num, int[] nums,
                                           Map<Integer, Boolean> visitedMap) {
        int count  = 1;
        int temp = num+1;
        //Check for next elements
        while(visitedMap.containsKey(temp) && visitedMap.get(temp) == false) {
            visitedMap.put(temp, true);
            temp = temp + 1;
            count++;

        }

        //Check for previous elements
        temp = num-1;
        while(visitedMap.containsKey(temp) && visitedMap.get(temp) == false) {
            visitedMap.put(temp, true);
            temp = temp - 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        P128_LongestConsecutiveSequenceUnsortedArray mainObject = new
                P128_LongestConsecutiveSequenceUnsortedArray();
        //int[] input = {100, 4, 200, 1, 3, 2};
        //int[] input = {5,3,2,1};
        int[] input = {1,10,111};
        System.out.println(mainObject.longestConsecutive(input));
    }

}