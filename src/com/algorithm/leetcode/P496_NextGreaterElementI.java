package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are
 * subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding
 * places of nums2.
 The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 If it does not exist, output -1 for this number.

 Example 1:
 Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 Output: [-1,3,-1]
 */
public class P496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) {
            return new int[]{};
        }
        if(nums2 == null || nums2.length == 0) {
            int[] result = new int[nums1.length];
            Arrays.fill(result, -1);
            return result;
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.push(nums2[i]);
                resultMap.put(nums2[i], -1);
            } else {
                if(nums2[i] < stack.peek()) {
                    resultMap.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                } else { //nums2[i] > stack.peek()
                    while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                        stack.pop();
                    }
                    if(stack.isEmpty()) {
                        resultMap.put(nums2[i], -1);
                    } else {
                        resultMap.put(nums2[i], stack.peek());
                    }
                    stack.push(nums2[i]);
                }
            }
        }

        int[] result = new int[nums1.length];
        for(int i=0; i <nums1.length; i++) {
            result[i] = resultMap.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        P496_NextGreaterElementI mainObject = new P496_NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = mainObject.nextGreaterElement(nums1, nums2);
        Arrays.stream(result).forEach(element -> System.out.print(element + " "));
    }
}
