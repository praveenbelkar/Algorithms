package com.algorithm.praveen.dynamicprogram;

//Count number of ways in which the "total" can be achieved from the given set of coins - coins can be used more than once
public class CoinChangeInfiniteSupplyOfCoins {

    private static int[] coins = {1,2,3};

    private int coinChange(int total, int numberOfCoins, int[][] mem) {
        if(total == 0)
            return 1;
        if(numberOfCoins <= 0 && total > 0) {
            return 0;
        }
        if(total < 0) {
            return 0;
        }
        if(mem[total][numberOfCoins] != -1) {
            return mem[total][numberOfCoins];
        }
        mem[total][numberOfCoins] = coinChange(total, numberOfCoins -1, mem) + coinChange(total - coins[numberOfCoins-1], numberOfCoins, mem);
        return mem[total][numberOfCoins];
    }

    public static void main(String[] args) {
        CoinChangeInfiniteSupplyOfCoins mainObject = new CoinChangeInfiniteSupplyOfCoins();
        int total = 6;
        int numberOfCoins = coins.length;
        int[][] mem = new int[total+1][numberOfCoins+1];
        for(int i=0; i<=total; i++) {
            for(int j=0; j<=numberOfCoins; j++) {
                mem[i][j] = -1;
            }
        }
        int solution = mainObject.coinChange(total, numberOfCoins, mem);
        System.out.println(solution);
    }
}
