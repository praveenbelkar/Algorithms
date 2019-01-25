package com.algorithm.praveen.dynamicprogram;

public class CuttingRod {

    public int cuttingRodRecursive(int[] lengths, int[] profit, int totalLength) {
        if(totalLength <= 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < lengths.length; i++) {
            maxProfit = Math.max(
                    cuttingRodRecursive(lengths, profit, totalLength - lengths[i]) + profit[i],
                    maxProfit
                    );
        }
        return maxProfit;
    }

    public int cuttingRodDP(int[] lengths, int[] profit, int totalLength) {
        int[][] table = new int[lengths.length][totalLength+1];
        for(int i=0; i < lengths.length; i++) {
            table[i][0] = 0;
        }
        for(int j=0; j <= totalLength; j++) {
            table[0][j] = j * profit[0];
        }

        for(int i=1; i < lengths.length; i++) {
            for(int j=1; j <= totalLength; j++) {
                if(j < lengths[i]) {
                    table[i][j] = table[i-1][j];
                } else {
                    table[i][j] = Math.max(
                                        table[i-1][j],
                                        table[i][j-lengths[i]] + profit[i]);
                }
            }
        }

        return table[lengths.length-1][totalLength];
    }

    public static void main(String[] args) {
        CuttingRod mainObject = new CuttingRod();
        int[] lengths = new int[]{1,2,3,4};
        int[] profits = new int[]{2,5,7,8};
        int totalLength = 5;
        System.out.println(mainObject.cuttingRodRecursive(lengths, profits, totalLength));
        System.out.println(mainObject.cuttingRodDP(lengths, profits, totalLength));
    }
}
