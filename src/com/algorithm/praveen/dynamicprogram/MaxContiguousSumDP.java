package com.algorithm.praveen.dynamicprogram;

import com.algorithm.praveen.misc.MaxContiguousSum;
import com.algorithm.praveen.misc.MaxContiguousSum.MaxSubArray;

/**
 * Given an array of integers find the sub array for which sum is maximum, using dynamic programming
 * @author Praveen Belkar
 *
 */
public class MaxContiguousSumDP {

	public int maxContiguousDp(int[] input) {
		int[] M = new int[input.length];
		if(input[0] > 0) {
			M[0] = input[0];
		} else {
			M[0] = 0;
		}
		
		for(int i=1; i<M.length; i++) {
			M[i] = 0;
		}
		
		for(int i=1; i<input.length; i++) {
			if(M[i-1] + input[i] > 0){
				M[i] = M[i-1] + input[i];
			} else {
				M[i] = 0;
			}
		}
		
		return maxValue(M);
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
		int[] input1 = new int[]{-2, 11, -4, 13, -5, 2};
		int[] input2 = new int[]{1, -3, 4, -2, -1, 6};
		
		MaxContiguousSumDP mainObject = new MaxContiguousSumDP();
		int result1 = mainObject.maxContiguousDp(input1);
		System.out.println(result1);
		
		int result2 = mainObject.maxContiguousDp(input2);
		System.out.println(result2);
	}

}
