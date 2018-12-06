package com.algorithm.praveen.dynamicprogram;

public class LongestCommonSubString {

    public void longestCommonSubString(String input1, String input2) {
        int[][] lcs = new int[input1.length()+1][input2.length()+1];
        char[] cInput1 = input1.toCharArray();
        char[] cInput2 = input2.toCharArray();

        int max = Integer.MIN_VALUE;
        int startIndex = 0;
        for(int i = 1; i < cInput1.length; i++) {
            for(int j = 1; j < cInput2.length; j++) {
                if(cInput1[i] == cInput2[j]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = 0;
                }

                if(lcs[i][j] > max) {
                    max = lcs[i][j];
                }
            }
        }

        //System.out.println(maxInArray(lcs, input1.length(), input2.length()));
        System.out.println(max);
        System.out.println(startIndex);
        //System.out.println(input1.substring(startIndex-1, startIndex-1+max));
    }

    public int maxInArray(int[][] lcs, int row, int col) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(lcs[i][j] > max) {
                    max = lcs[i][j];
                }
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        String input1 = "abcdefghij";
        String input2 = "abcdefklmefghijqwer";

        LongestCommonSubString mainObject = new LongestCommonSubString();
        mainObject.longestCommonSubString(input1, input2);
    }
}
