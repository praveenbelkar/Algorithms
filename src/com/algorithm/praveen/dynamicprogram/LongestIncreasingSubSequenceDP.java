package com.algorithm.praveen.dynamicprogram;

/**
 * Find the longest subsequence of an array which is in increasing order, using dynamic programming
 * @author Praveen Belkar
 *
 */
public class LongestIncreasingSubSequenceDP {

	
	public int getLongestIncreasingSubArray(int[] input) {
		int[] maxArray = new int[input.length];
		maxArray[0] = 1;
		
		for(int i=1; i < input.length; i++) {
			if(input[i] >= input[i-1]) {
				maxArray[i] = maxArray[i-1] + 1;
			} else {
				maxArray[i] = 1;
			}
		}
		
		return maxValue(maxArray);
	}
	
	public int maxValue(int[] input) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i< input.length; i++) {
			if(input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] input = new int[]{2,3,4,2,4,3,2,3,4,5,6,3,4};
		
		LongestIncreasingSubSequenceDP mainObject = new LongestIncreasingSubSequenceDP();
		System.out.println(mainObject.getLongestIncreasingSubArray(input));
	}

}
