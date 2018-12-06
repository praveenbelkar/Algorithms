package com.algorithm.praveen.dynamicprogram;

//Get the length of longest palindromic subsequence in the given input string
public class LongestPalindromeSubSequence {

    public int longestPalidromeRecursion(String input, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            return 1;
        }
        if(input.charAt(startIndex) == input.charAt(endIndex)) {
            return 2 + longestPalidromeRecursion(input, startIndex + 1, endIndex - 1 );
        } else {
            return Math.max(longestPalidromeRecursion(input, startIndex, endIndex - 1),
                            longestPalidromeRecursion(input, startIndex + 1, endIndex));
        }
    }

    public int longestPalidromeDP(String input) {
        int n = input.length();
        int[][] table = new int[n + 1][n + 1];
        for(int i = 0; i < input.length(); i++) {
            table[i][i] = 1;
        }
        for(int length = 2; length <= input.length(); length++) {
            int maxStartIndexAllowed = input.length() - length;
            for(int i = 0; i <= maxStartIndexAllowed; i++) {
                int j = i + length - 1;
                if(input.charAt(i) == input.charAt(j)) {
                    table[i][j] = 2 + table[i+1][j-1];
                } else {
                    table[i][j] = Math.max(table[i+1][j], table[i][j-1]);
                }
            }
        }

        return table[0][input.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubSequence mainObject = new LongestPalindromeSubSequence();
        String input = "agbdba";
        System.out.println(mainObject.longestPalidromeRecursion(input, 0, input.length() - 1));
        System.out.println(mainObject.longestPalidromeDP(input));
    }
}
