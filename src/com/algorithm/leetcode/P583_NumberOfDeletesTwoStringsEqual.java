package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class P583_NumberOfDeletesTwoStringsEqual {

    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);

        return (word1.length() - lcs) + (word2.length() - lcs);
    }

    private int longestCommonSubsequence(String word1, String word2) {
        int[][] table = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < word1.length()+1; i++) {

            for(int j = 0; j < word2.length()+1; j++) {

                if(i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }

                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    table[i][j] = 1 + table[i-1][j-1];
                } else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }

        return table[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        P583_NumberOfDeletesTwoStringsEqual mainObject = new P583_NumberOfDeletesTwoStringsEqual();
        System.out.println(mainObject.minDistance("sea","eat"));
    }
}
