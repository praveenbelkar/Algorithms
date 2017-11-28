package com.algorithm.praveen.misc;

/**
 * Given an array of integers find the sub array for which sum is maximum
 * @author Praveen Belkar
 *
 */
public class MaxContiguousSum {

	public static class MaxSubArray {
		int startIndex = -1;
		int endIndex = -1;
		int sum = 0;
		
		@Override
		public String toString() {
			return "MaxSubArray [startIndex=" + startIndex + ", endIndex=" + endIndex + ", sum=" + sum + "]";
		}
	}
	
	public MaxSubArray maxContiguous(int[] input) {
		int maxSumSofar = 0;
		int maxSumEndingHere = 0;
		int maxSumStartIndex = 0;
		int maxSumEndIndex = 0;
		int currentBlockStartIndex = 0;
		int currentBlockEndIndex = 0;
		MaxSubArray resultSubArray = new MaxSubArray();
		
		for(int i=0; i < input.length; i++) {
			maxSumEndingHere = maxSumEndingHere + input[i];
			if(maxSumEndingHere > maxSumSofar) {
				maxSumSofar = maxSumEndingHere;
				maxSumEndIndex = i;
				maxSumStartIndex = currentBlockStartIndex;
			}
			if(maxSumEndingHere < 0){
				currentBlockStartIndex = i+1;
				maxSumEndingHere = 0;
			}
		}
		
		resultSubArray.sum = maxSumSofar;
		resultSubArray.startIndex = maxSumStartIndex;
		resultSubArray.endIndex = maxSumEndIndex;
		return resultSubArray;
	}
	
	public static void main(String[] args) {
		int[] input1 = new int[]{-2, 11, -4, 13, -5, 2};
		int[] input2 = new int[]{1, -3, 4, -2, -1, 6};
		
		MaxContiguousSum mainObject = new MaxContiguousSum();
		MaxSubArray maxSubArray1 = mainObject.maxContiguous(input1);
		System.out.println(maxSubArray1);
		
		MaxSubArray maxSubArray2 = mainObject.maxContiguous(input2);
		System.out.println(maxSubArray2);

	}
	
}
