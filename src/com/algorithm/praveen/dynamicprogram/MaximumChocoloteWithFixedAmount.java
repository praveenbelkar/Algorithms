package com.algorithm.praveen.dynamicprogram;

/**
 * A bunch of shops sells a bundle of chocolates at a fixed cost.
 * You are given a fixed amount and price sheet of shops,
 * Find the maximum number of chocolates that you can buy with the given amount
 */
public class MaximumChocoloteWithFixedAmount {

    public int maxNumberChocolates(int amount, int[] quantities, int[] cost, int n) {
        if(amount <= 0 || n < 0) {
            return 0;
        }
        if(amount < cost[n]) {
            return maxNumberChocolates(amount, quantities, cost, n-1);
        } else {
            return Math.max(
                    maxNumberChocolates(amount - cost[n], quantities, cost, n) + quantities[n],
                    maxNumberChocolates(amount, quantities, cost, n-1));
        }
    }

    public int maxNumberChocolatesDpBottomUp(int amount, int[] quantities, int[] cost, int n) {
        int[][] table = new int[amount+1][quantities.length+1];
        for(int i=0; i <= amount; i++) {

            for(int j=0; j <= quantities.length; j++) {
                if(i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }

                if(i < cost[j-1]) {
                    table[i][j] = table[i][j-1];
                } else {
                    table[i][j] = Math.max(
                                    table[i-cost[j-1]][j] + quantities[j-1],
                                    table[i][j-1]);
                }
            }
        }
        return table[amount][quantities.length];
    }

    public static void main(String[] args) {
        MaximumChocoloteWithFixedAmount mainObject = new MaximumChocoloteWithFixedAmount();
        int[] quantities = {10, 9};
        int[] cost = {10, 1};
        int amount = 10;
        System.out.println(mainObject.maxNumberChocolates(amount, quantities, cost, quantities.length - 1));
        System.out.println(mainObject.maxNumberChocolatesDpBottomUp(amount, quantities, cost, quantities.length - 1));
    }
}

