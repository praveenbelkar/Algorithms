package com.algorithm.bytebybyte;

public class Knapsack {

    public int knapackRecursive(int[] weights, int[] values, int maxWeight, int n){
        if(n==weights.length){
            return 0;
        }
        if(weights[n] <= maxWeight){
            return Math.max(knapackRecursive(weights, values, maxWeight, n+1),
                    knapackRecursive(weights, values, maxWeight - weights[n], n+1) + values[n]);
        } else {
            return knapackRecursive(weights, values, maxWeight, n+1);
        }
    }

    public int knapsackBottomUpDp(int[] weights, int[] values, int maxWeight) {
        int[][] cache = new int[weights.length+1][maxWeight+1];
        for(int i=0; i<=weights.length; i++){
            for(int w=0; w<=maxWeight; w++){
                if(i==0 || w==0){
                    cache[i][w] = 0;
                }else if(weights[i-1] <= w){
                    cache[i][w] = Math.max(cache[i-1][w-weights[i-1]] + values[i-1],
                            cache[i-1][w]);
                } else {
                    cache[i][w] = cache[i-1][w];
                }
            }
        }
        return cache[weights.length][maxWeight];
    }

    public static void main(String[] args) {
        Knapsack mainObject = new Knapsack();
        int[] weights = {1,2,3};
        int[] values = {6,10,12};
        int maxWeight = 5;
        System.out.println(mainObject.knapackRecursive(weights, values, maxWeight, 0));
        System.out.println(mainObject.knapsackBottomUpDp(weights, values, maxWeight));
    }
}
