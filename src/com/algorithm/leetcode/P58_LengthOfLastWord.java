package com.algorithm.leetcode;

import java.util.StringTokenizer;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class P58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(null == s || s.trim().length() == 0) {
            return 0;
        }

        String[] tokenizedInput = s.split(" ");
        return tokenizedInput[tokenizedInput.length - 1].length();
    }

    public static void main(String[] args) {
        P58_LengthOfLastWord mainObject = new P58_LengthOfLastWord();
        String input = "Hello World";
        System.out.println(mainObject.lengthOfLastWord(input));
    }
}
