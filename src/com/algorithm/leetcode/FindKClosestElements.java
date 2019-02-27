package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(null == arr || arr.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if(x <= arr[0]){
            return getStartingElements(arr, k, result);
        }

        if(x >= arr[arr.length-1]){
            return getEndElements(arr, k, result);
        }

        int indexOfNearestElement = findClosestElement(arr, x);

        int decrementIndex = indexOfNearestElement - 1;
        int incrementIndex = indexOfNearestElement + 1;
        result.add(arr[indexOfNearestElement]);
        boolean lowTerminated = false;
        boolean highTerminated = false;
        for(int count=0; count < k-1; count++) {
            int lowerDiff =  lowTerminated ? Integer.MAX_VALUE: Math.abs(x-arr[decrementIndex]);
            int higherDiff = highTerminated ? Integer.MAX_VALUE: Math.abs(x-arr[incrementIndex]);
            if( higherDiff < lowerDiff) {
                result.add(arr[incrementIndex]);
                incrementIndex++;
                if(incrementIndex > arr.length-1) {
                    highTerminated = true;
                }
            } else {
                result.add(arr[decrementIndex]);
                decrementIndex--;
                if(decrementIndex < 0) {
                    lowTerminated = true;
                }
            }
        }
        result.sort((element1, element2) -> element1 - element2);
        return result;
    }

    private List<Integer> getEndElements(int[] arr, int k, List<Integer> result) {
        for(int i=arr.length-1, j=0; j < k; i--, j++) {
            result.add(arr[i]);
        }
        result.sort((element1, element2) -> element1 - element2);
        return result;
    }

    private List<Integer> getStartingElements(int[] arr, int k, List<Integer> result) {
        for(int i=0; i < k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public int findClosestElement(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int closest = Integer.MAX_VALUE;
        int currentDiff = 0;
        int lowestDiff = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            currentDiff = Math.abs(arr[mid] - x);
            if(currentDiff < lowestDiff) {
                lowestDiff = currentDiff;
                closest = mid;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        FindKClosestElements mainObject = new FindKClosestElements();
        int[] input = {1,2,3,4,5};
        int k=4, x=3;
        //int k=2, x=-2;
        //int[] input = {0,1,2,2,2,3,6,8,8,9};
        //int k=5, x=0;
        //int[] input = {0,1,1,1,2,3,6,7,8,9};
        //int k=9,x=4;
        //int[] input = {1,2,3,3,6,6,7,7,9,9};
        //int k=8, x=8;
        List<Integer> result = mainObject.findClosestElements(input, k, x);
        result.stream().forEach(element -> System.out.print(element + " "));
    }

}
