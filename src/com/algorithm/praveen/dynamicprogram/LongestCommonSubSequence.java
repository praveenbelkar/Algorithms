package com.algorithm.praveen.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubSequence {

    public void longestCommonSubSequence(int[] input1, int[] input2) {
        int[][] lcs = new int[input1.length+1][input2.length+1];
        for(int i = 0; i <= input1.length; i++) {
            for(int j =0; j <= input2.length; j++) {
                lcs[i][j] = 0;
            }
        }

        for(int i = 1; i <= input1.length; i++) {
            for (int j = 1; j <= input2.length; j++) {
                if( input1[i-1] == input2[j-1] ) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = 1 + Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        for(int i = 0; i <= input1.length; i++){
            for(int j = 0; j <= input2.length; j++) {
                System.out.print(lcs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(lcs[input1.length][input2.length]);

        printLargestSubSequence(lcs, input1, input2);

    }

    private void printLargestSubSequence(int[][] lcs, int[] input1, int[] input2) {
        System.out.println("----------------");
        int i = input1.length;
        int j = input2.length;

        List<Integer> commonEntries = new ArrayList<Integer>();
        while ( i > 0 && j > 0) {
            if(lcs[i][j] != Math.max(lcs[i-1][j], lcs[i][j-1])) {
                //System.out.println(input1[i-1]);
                commonEntries.add(input1[i-1]);
                i--;
                j--;

            } else {
                if(lcs[i-1][j] > lcs[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        for(int k = commonEntries.size()-1; k >=0 ; k-- ) {
            System.out.print(commonEntries.get(k) + " ");
        }

    }

    public static void main(String[] args) {
        //int[] input1 = {2,3,5,6,10,12,14,15};
        //int[] input2 = {2,5,7,9,6,10,11,13,14};
        //              2,5,6,10,14

        //int[] input1 = {2,3,5};
        //int[] input2 = {2,5,7};

        int[] input1 = {1,2,3,5,6,10,12,14,15};
        int[] input2 = {2,5,7,9,6,10,11,13,14};
        //int[] input1 = {3};
        //int[] input2 = {3};

        LongestCommonSubSequence mainObject = new LongestCommonSubSequence();
        mainObject.longestCommonSubSequence(input1, input2);
    }
}
