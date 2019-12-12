package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class P1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String word1, String word2) {
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
        P1143_LongestCommonSubsequence mainObject = new P1143_LongestCommonSubsequence();
        System.out.println(mainObject.longestCommonSubsequence("abcde","ace"));
        System.out.println(mainObject.longestCommonSubsequence("abc","abc"));
        System.out.println(mainObject.longestCommonSubsequence("abc","def"));
    }
}
