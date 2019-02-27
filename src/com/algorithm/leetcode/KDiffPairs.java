package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 */
public class KDiffPairs {

    public static class Pair {
        public Integer x;
        public Integer y;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            boolean b1 = x.equals(pair.x) && y.equals(pair.y);
            boolean b2 = x.equals(pair.y) && y.equals(pair.x);
            return b1 || b2;
        }

        @Override
        public int hashCode() {
            int result = x.hashCode() + y.hashCode();
            return result;
        }
    }

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Pair> results = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i])) {
                numSet.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i] - k)) {
                Pair pair = new Pair();
                pair.x = nums[i];
                pair.y = nums[i] - k;
                if(!results.contains(pair)) {
                    results.add(pair);
                }
            }

            if (numSet.contains(nums[i] + k)) {
                Pair pair = new Pair();
                pair.x = nums[i];
                pair.y = nums[i] + k;
                if(!results.contains(pair)) {
                    results.add(pair);
                }
            }
        }

        results.stream().forEach(element -> System.out.println(element.x + " " + element.y));
        return results.size();
    }

    public static void main(String[] args) {
        KDiffPairs mainObject = new KDiffPairs();
        int[] nums = new int[]{3, 1, 4, 1, 5};
        int k = 0;

        System.out.println(mainObject.findPairs(nums, k));
        Pair pair1 = new Pair();
        pair1.x = 2;
        pair1.y = 3;

        Pair pair2 = new Pair();
        pair2.x = 3;
        pair2.y = 2;

        System.out.println(pair1.equals(pair2));
    }

}

