package com.algorithm.praveen.dynamicprogram;

import java.util.Arrays;

//Count what is the minimum number of coins needed to form an amount, with infinite supply of coins
public class MinCoinsInfiniteSupply {

    public int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //Base condition
        dp[0] = 0;

        for(int money=1; money <= amount; money++) {
            for(int i=0; i < coins.length; i++) {
                if(coins[i] <= money) {
                    int smallerCoin = dp[money - coins[i]];
                    if(smallerCoin != Integer.MAX_VALUE) {
                        dp[money] = Math.min(smallerCoin + 1, dp[money]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(coins));
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] us_coins = {1,7,10};
        int amount_us = 15;

        int[] indian_coins = {1,2,5,10,50};
        int  amount_indian = 13;

        MinCoinsInfiniteSupply mainObject = new MinCoinsInfiniteSupply();
        System.out.println(mainObject.minCoins(us_coins, amount_us));
        //System.out.println(mainObject.minCoins(indian_coins, amount_indian));
    }
}
