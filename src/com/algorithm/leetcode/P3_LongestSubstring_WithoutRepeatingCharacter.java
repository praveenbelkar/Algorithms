package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class P3_LongestSubstring_WithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] positions = new int[256];
        Arrays.fill(positions, -1);
        int result = 1;
        int positionOfRecentRepeatedCharacter = -1;
        for(int i=0; i < s.length(); i++) {
            int character = s.charAt(i);
            if(positions[character] == -1) {
                positions[character] = i;
                result = Math.max(result, i - positionOfRecentRepeatedCharacter);
            } else {
                positionOfRecentRepeatedCharacter = Math.max(positionOfRecentRepeatedCharacter, positions[character]);
                int currentLength = i - positionOfRecentRepeatedCharacter;
                result = Math.max(result, currentLength);
                positions[character] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P3_LongestSubstring_WithoutRepeatingCharacter mainObject = new P3_LongestSubstring_WithoutRepeatingCharacter();
        System.out.println(mainObject.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(mainObject.lengthOfLongestSubstring("bbbbb"));
        System.out.println(mainObject.lengthOfLongestSubstring("pwwkew"));
        System.out.println(mainObject.lengthOfLongestSubstring("au"));
        System.out.println(mainObject.lengthOfLongestSubstring("abba"));

    }
}
