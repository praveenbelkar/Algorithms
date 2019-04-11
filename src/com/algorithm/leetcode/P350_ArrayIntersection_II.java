package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 */
public class P350_ArrayIntersection_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        if( (null == nums1 || nums1.length == 0) || (null == nums2 || nums2.length == 0) ) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        Integer count = 0;
        for(Integer element: nums1) {
            count = map.get(element);
            if(count == null) {
                map.put(element, 1);
            } else {
                count++;
                map.put(element, count);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(Integer element: nums2) {
            if(map.containsKey(element)) {
                result.add(element);
                count = map.get(element);
                count--;
                if(count == 0){
                    map.remove(element);
                } else {
                    map.put(element, count);
                }
            }
        }

        int[] resultArray = new int[result.size()];
        int index = 0;
        for(Integer element: result) {
            resultArray[index++] = element;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        P350_ArrayIntersection_II mainObject = new P350_ArrayIntersection_II();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = mainObject.intersect(nums1, nums2);

        Arrays.stream(result).forEach(element -> System.out.print(element+ " "));
        System.out.println();

    }
}
