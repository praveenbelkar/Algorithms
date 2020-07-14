package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/target-sum/
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class P494_TargetSumWithPlusMinusSymbols {

    private static class Entry {
        int index;
        int sum;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return index == entry.index &&
                    sum == entry.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, sum);
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        //int dp[][] = new int[nums.length + 1][S+1];
        Map<Entry, Integer> dp = new HashMap<>();
        /*for(int i=0; i < nums.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }*/
        return findTargetSumWays(nums, 0, S, dp);
    }

    private int findTargetSumWays(int[] nums, int startIndex, int sum, Map<Entry, Integer> dp) {
        Entry entry = new Entry();
        entry.index = startIndex;
        entry.sum = sum;

        if(startIndex >= nums.length && sum != 0) {
            dp.put(entry, 0);
            return 0;
        }

        if(startIndex >= nums.length  && sum == 0) {
            dp.put(entry, 1);
            return 1;
        }


        if(dp.containsKey(entry)) {
            return dp.get(entry);
        }

        int cnt1 = findTargetSumWays(nums, startIndex+1, sum - nums[startIndex], dp);

        int cnt2 = findTargetSumWays(nums, startIndex+1, sum + nums[startIndex], dp);

        dp.put(entry, cnt1+cnt2);
        return cnt1 + cnt2;
    }

    public static void main(String[] args) {
        P494_TargetSumWithPlusMinusSymbols mainObject = new P494_TargetSumWithPlusMinusSymbols();
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(mainObject.findTargetSumWays(nums, S));
    }
}
