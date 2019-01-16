package com.algorithm.bytebybyte;

import java.util.Arrays;

/**
 * Given K-sorted arrays, merge them into one sorted array
 */
public class MergeKSortedArrays {

    public int[] mergeKsortedArrays(int[][] input) {
        //Going with assumption that all arrays are of equal length
        int eachArrayLength = input[0].length;
        int numberOfArrays = input.length;
        int[] resultArray = new int[eachArrayLength * numberOfArrays];
        int[] arrayPositions = new int[numberOfArrays];

        Arrays.fill(arrayPositions, 0);
        int resultArrayIndex = 0;
        while(arraysAreRemaining(arrayPositions)) {
            int smallestElement = getSmallestElement(input, arrayPositions);
            resultArray[resultArrayIndex++] = smallestElement;
        }
        return resultArray;
    }

    private int getSmallestElement(int[][] input, int[] arrayPositions) {
        int smallestElement = Integer.MAX_VALUE;
        int smallestElementArray = 0;

        for(int i=0; i<arrayPositions.length; i++) {
            int arrayPositionForIthArray = arrayPositions[i];
            if(arrayPositionForIthArray == -1){
                continue;
            }
            if(input[i][arrayPositionForIthArray] < smallestElement){
                smallestElement = input[i][arrayPositionForIthArray];
                smallestElementArray = i;
            }
        }
        if(arrayPositions[smallestElementArray]+1 >= input[0].length){
            arrayPositions[smallestElementArray] = -1;
        }else{
            arrayPositions[smallestElementArray]++;
        }
        return smallestElement;
    }

    private boolean arraysAreRemaining(int[] arrayPositions) {
        //If all elements for an array are over, then we store -1 as index for that array
        for(int i=0; i < arrayPositions.length; i++) {
            if(arrayPositions[i] != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MergeKSortedArrays mainObject = new MergeKSortedArrays();
        int[][] input = {{1,4,7},
                {2,5,8},
                {3,6,9}};
        int[] result = mainObject.mergeKsortedArrays(input);
        System.out.println("Result ->");
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }
}
