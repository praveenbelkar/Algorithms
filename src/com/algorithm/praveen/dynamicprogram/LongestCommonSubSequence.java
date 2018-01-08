package com.algorithm.praveen.dynamicprogram;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public void longestCommonSubSequence(int[] input1, int[] input2) {
        int[][] lcs = new int[input1.length+1][input2.length+1];
        for(int i = 0; i < input1.length; i++) {
            for(int j =0; j <input2.length; j++) {
                lcs[i][j] = 1;
            }
        }

        for(int i = 1; i < input1.length; i++) {
            for (int j = 1; j < input2.length; j++) {
                if( input1[i] == input2[j] ) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        for(int i = 0; i < input1.length; i++){
            for(int j = 0; j < input2.length; j++) {
                System.out.print(lcs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(lcs[input1.length-1][input2.length-1]);

        printLargestSubSequence(lcs);

    }

    private void printLargestSubSequence(int[][] lcs) {

    }

    public static void main(String[] args) {
        int[] input1 = {2,3,5,6,10,12,14,15};
        int[] input2 = {2,5,7,9,6,10,11,13,14};
        //              2,5,6,10,14

        LongestCommonSubSequence mainObject = new LongestCommonSubSequence();
        mainObject.longestCommonSubSequence(input1, input2);
    }
}
