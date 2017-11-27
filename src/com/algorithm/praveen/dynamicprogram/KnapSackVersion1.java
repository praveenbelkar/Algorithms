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
public class KnapSackVersion1 {

	private int[] values;
	private int[] weights;
	private int capacity = 0;
	
	public int knapsack(int weight, int n) {
		//Base case
		if(weight <= 0 || n <= 0){
			return 0;
		}
		
		if(weights[n-1]  > capacity) {
			return knapsack(weight, n-1); 
		}
		
		return Math.max(knapsack(weight, n-1), 
						knapsack(weight - weights[n], n-1) + values[n]);
	}
	
	public static void main(String[] args) {
		KnapSackVersion1 knapSackObject = new KnapSackVersion1();
		knapSackObject.values = new int[]{60, 100, 120};
		knapSackObject.weights = new int[]{10, 20, 30};
		knapSackObject.capacity = 50;
		
		System.out.println(knapSackObject.knapsack(knapSackObject.capacity, knapSackObject.values.length-1));

	}
}
