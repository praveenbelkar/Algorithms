package com.algorithm.bytebybyte;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.byte-by-byte.com/consecutivearray
 * Given an unsorted array, find the length of the longest sequence of consecutive numbers in the array.
 eg.
 consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
 consecutive([5, 5, 3, 1]) = 1, [1], [3], or [5]
 */
public class ConsecutiveArray {

    public int longestConsecutiveArray(int[] input){
        Set<Integer> set = new HashSet<>();
        for(Integer element: input){
            set.add(element);
        }

        int maxCnt = Integer.MIN_VALUE;
        for(int i=0; i<input.length; i++){
            int cnt=0;
            if(isLeftMostOccurrence(input[i], set)){
                int nextNumber = input[i];
                while(set.contains(nextNumber)) {
                    cnt++;
                    nextNumber++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        }
        return maxCnt;
    }

    private boolean isLeftMostOccurrence(int element, Set<Integer> set) {
        return !set.contains(element-1);
    }

    public static void main(String[] args) {
        ConsecutiveArray mainObject = new ConsecutiveArray();
        //int[] input = {4,2,1,6,5};
        int[] input = {5,5,3,1};
        System.out.println(mainObject.longestConsecutiveArray(input));
    }
}
