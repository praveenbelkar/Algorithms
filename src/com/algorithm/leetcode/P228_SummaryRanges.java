package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class P228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        if(nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int count = 0;
        int num1 = nums[0];
        int num2 = nums[1];
        String element = Integer.toString(num1);
        String start = null;
        String end = element;
        for(int i = 1; i < nums.length; i++) {
            num2 = nums[i];
            if(num2 - num1 == 1) {
                if(count == 0) {
                    start = Integer.toString(num1);
                }
                num1 = num2;
                count++;
                continue;
            }
            if(count > 0) {
                result.add(start + "->"+Integer.toString(num1));
                count = 0;
                num1 = num2;
                continue;
            }

            result.add(Integer.toString(num1));
            num1 = num2;
        }

        if(count > 0) {
            result.add(start + "->"+Integer.toString(num1));
            count = 0;
            num1 = num2;
        } else {
            result.add(Integer.toString(num1));
            num1 = num2;
        }

        return result;
    }

    public static void main(String[] args) {
        P228_SummaryRanges mainObject = new P228_SummaryRanges();
        //int[] input = {0,2,3,4,6,8,9};
        //int[] input = {0,1,2,4,5,7};
        int[] input = {0};
        List<String> result = mainObject.summaryRanges(input);
        result.stream().forEach(element -> System.out.print(" " + element));
    }
}
