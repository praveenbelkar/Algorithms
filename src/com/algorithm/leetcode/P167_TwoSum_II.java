package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class P167_TwoSum_II {

    public int[] twoSum(int[] numbers, int target) {
        if(null == numbers || numbers.length == 0) {
            return null;
        }

        int low = 0;
        int high = numbers.length - 1;
        int num1 = 0;
        int num2 = 0;
        int[] result = new int[2];
        while(low < high) {
            num1 = numbers[low];
            num2 = numbers[high];
            if(num1 + num2 == target) {
                result[0] = low+1;
                result[1] = high+1;
                break;
            } else if(num1 + num2 > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P167_TwoSum_II mainObject = new P167_TwoSum_II();
        int[] numbers = {2,7,11,15};
        int[] result = mainObject.twoSum(numbers, 9);
        System.out.println(result[0] + " " + result[1]);
    }

}
