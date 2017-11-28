package com.algorithm.praveen.misc;

/**
 * Find the longest subsequence of an array which is in increasing order
 * @author Praveen Belkar
 *
 */
public class LongestIncreasingSubSequence {

	public static class SubArrayInfo {
		int startIndex = 0;
		int endIndex = 0;
		int subSequenceLength = 0;
		
		public SubArrayInfo(int startIndex, int endIndex, int subSequenceLength) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.subSequenceLength = subSequenceLength;
		}

		@Override
		public String toString() {
			return "SubArrayInfo [startIndex=" + startIndex + ", endIndex=" + endIndex + ", subSequenceLength="
					+ subSequenceLength + "]";
		}
		
	}
	
	public SubArrayInfo getLongestIncreasingSubArray(int[] input) {
		int startOfMaxSubArray = 0;
		int endOfMaxSubArray = 0;
		int startOfCurrentSequence = 0;
		int subArrayLength = 1;
		int maxLength = 1;
		
		for(int i=1; i< input.length; i++) {
			if(input[i] >= input[i-1]) {
				subArrayLength++;
				if(subArrayLength > maxLength) {
					maxLength = subArrayLength;
					startOfMaxSubArray = startOfCurrentSequence;
					endOfMaxSubArray = i;
				}
			} else {
				subArrayLength = 1;
				startOfCurrentSequence = i;
			}
		}
		
		return new SubArrayInfo(startOfMaxSubArray, endOfMaxSubArray, maxLength);
	}
	
	public static void main(String[] args) {
		int[] input = new int[]{2,3,4,2,4,3,2,3,4,5,6,3,4};
		
		LongestIncreasingSubSequence mainObject = new LongestIncreasingSubSequence();
		System.out.println(mainObject.getLongestIncreasingSubArray(input));
	}
}
