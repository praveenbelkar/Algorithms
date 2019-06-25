package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class P56_MergeInterval {

    private static class Custom {
        int start;
        int end;
    }


    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int n = m > 0 ? intervals[0].length: 0;
        if(m == 0 || n == 0 || m == 1) {
            return intervals;
        }

        List<Custom> customIntervals = new ArrayList<>();
        for(int i=0; i < m; i++) {
            Custom custom = new Custom();
            custom.start = intervals[i][0];
            custom.end = intervals[i][1];
            customIntervals.add(custom);
        }
        Collections.sort(customIntervals, (custom1, custom2) -> {
            return custom1.start - custom2.start;
        });

        Custom first = customIntervals.get(0);
        Custom second = customIntervals.get(1);
        List<Custom> mergedCustomList = new ArrayList<>();
        for(int i=1; i < customIntervals.size(); i++) {
            second = customIntervals.get(i);
            if(overlaps(first, second)) {
                first = mergeIntervals(first, second);
            } else {
                mergedCustomList.add(first);
                first = second;
            }
        }
        mergedCustomList.add(first);

        return getArrayFromCustomList(mergedCustomList);
    }

    private int[][] getArrayFromCustomList(List<Custom> mergedCustomList) {
        int[][] result = new int[mergedCustomList.size()][2];
        for(int i=0; i < mergedCustomList.size(); i++) {
            result[i][0] = mergedCustomList.get(i).start;
            result[i][1] = mergedCustomList.get(i).end;
        }
        return result;
    }

    private Custom mergeIntervals(Custom first, Custom second) {
        first.end = Math.max(first.end, second.end);
        return first;
    }

    private boolean overlaps(Custom first, Custom second) {
        return (second.start >= first.start && second.start <= first.end);
    }

    public static void main(String[] args) {
        P56_MergeInterval mainObject = new P56_MergeInterval();
        /*int[][] input = new int[][]{
                {1,3},{2,6},{8,10}, {15,18}
        };*/
        int[][] input = new int[][]{
                {1,4}
        };
        int[][] result = mainObject.merge(input);
        for(int i=0; i < result.length; i++) {
            System.out.println("("+result[i][0]+","+result[i][1]+"),");
        }
    }
}
