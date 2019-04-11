package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 */
public class P349_ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if( (null == nums1 || nums1.length == 0) || (null == nums2 || nums2.length == 0) ) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(Integer element: nums1) {
            set1.add(element);
        }

        for(Integer element: nums2) {
            if(set1.contains(element)) {
                set2.add(element);
            }
        }

        int[] resultArray = new int[set2.size()];
        if(set2.size() > 0) {
            int index = 0;
            for(Integer element: set2) {
                resultArray[index++] = element;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        P349_ArrayIntersection mainObject = new P349_ArrayIntersection();
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5};

        int[] result = mainObject.intersection(nums1, nums2);

        Arrays.stream(result).forEach(element -> System.out.print(element+ " "));
        System.out.println();
    }
}
