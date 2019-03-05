package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/majority-element/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:

 Input: [3,2,3]
 Output: 3
 Example 2:

 Input: [2,2,1,1,1,2,2]
 Output: 2
 */
public class P169_MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];

        for(int i=1; i < nums.length; i++) {
            if(nums[i] != majorityElement) {
                count--;
                if(count==0) {
                    majorityElement = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }

        return majorityElement;
    }

    public static void main(String[] args) {
        P169_MajorityElement mainObject = new P169_MajorityElement();
        int[] nums = {3,2,3};
        System.out.println(mainObject.majorityElement(nums));
    }
}


