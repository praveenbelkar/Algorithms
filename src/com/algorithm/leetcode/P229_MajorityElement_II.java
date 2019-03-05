package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Note: The algorithm should run in linear time and in O(1) space.

 Example 1:

 Input: [3,2,3]
 Output: [3]
 Example 2:

 Input: [1,1,1,3,3,2,2,2]
 Output: [1,2]
 */
public class P229_MajorityElement_II {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        if(nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int count1 = 0;
        Integer firstElement = null;

        int count2 = 0;
        Integer secondElement = null;

        for(int i=0; i < nums.length; i++) {
            if(firstElement == null || nums[i] == firstElement) {
                firstElement = nums[i];
                count1++;
                continue;
            }
            if(secondElement == null || nums[i] == secondElement) {
                secondElement = nums[i];
                count2++;
                continue;
            }

            count1--;
            count2--;
            if(count1 < 0) {
                firstElement = nums[i];
                count1 = 1;
                continue;
            }
            if(count2 < 0) {
                secondElement = nums[i];
                count2 = 1;
                continue;
            }

        }

        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i < nums.length; i++) {
            if(null != firstElement && nums[i] == firstElement) {
                cnt1++;
            }
            if(null != secondElement && nums[i] == secondElement) {
                cnt2++;
            }
        }

        if(cnt1 > nums.length/3) {
            result.add(firstElement);
        }
        if(cnt2 > nums.length/3) {
            result.add(secondElement);
        }
        return result;
    }

    public static void main(String[] args) {
        P229_MajorityElement_II mainObject = new P229_MajorityElement_II();
        int[] nums = {1,1,1,2,3,4,5,6};//{2,2};//{1};//{1,1,1,3,3,2,2,2};//{2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8};//{3,2,3};
        List<Integer> result = mainObject.majorityElement(nums);
        result.stream().forEach(element -> System.out.print(element + " "));
    }
}
