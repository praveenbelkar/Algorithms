package com.algorithm.praveen.dynamicprogram;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum
 *  total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] 
 *  which represent values and weights associated with n items respectively. Also given an integer W 
 *  which represents knapsack capacity, find out the maximum value subset of val[] such that sum of 
 *  the weights of this subset is smaller than or equal to W. You cannot break an item, either pick 
 *  the complete item, or don’t pick it (0-1 property).
 *  
 * @author Praveen Belkar
 *
 */

public class KnapSackVersion1Efficient {

	private int[] values;
	private int[] weights;
	private int capacity = 0;

	public int knapsack(int weight, int n) {
		int k[][] = new int[n+1][capacity+1];
		
		for(int i=0; i<=n; i++) {
			for(int w=0; w<=capacity; w++) {
				if(i==0 || w==0){
					k[i][w] = 0;
				} else if(weights[i] <= w) {
					k[i][w] = Math.max(k[i-1][w - weights[i]] + values[i-1], k[i-1][w]);
				} else {
					k[i][w] = k[i-1][w];
				}
			}
		}
		
		return k[n][capacity];
	}
	
	public static void main(String[] args) {
		KnapSackVersion1Efficient knapSackObject = new KnapSackVersion1Efficient();
		knapSackObject.values = new int[]{60, 100, 120};
		knapSackObject.weights = new int[]{10, 20, 30};
		knapSackObject.capacity = 50;
		
		System.out.println(knapSackObject.knapsack(knapSackObject.capacity, knapSackObject.values.length));

	}

}
