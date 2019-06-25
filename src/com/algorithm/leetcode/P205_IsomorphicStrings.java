package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 */
public class P205_IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        for(int i=0; i < charArray1.length; i++) {
            if(map1.containsKey(charArray1[i])) {
                if(charArray2[i] != map1.get(charArray1[i])) {
                    return false;
                }
            } else {
                if(map2.containsKey(charArray2[i])) {
                    return false;
                } else {
                    map1.put(charArray1[i], charArray2[i]);
                    map2.put(charArray2[i], charArray1[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P205_IsomorphicStrings mainObject = new P205_IsomorphicStrings();
        System.out.println(mainObject.isIsomorphic("aaa", "aaa"));
        //System.out.println(mainObject.isIsomorphic("egg", "add"));
        //System.out.println(mainObject.isIsomorphic("foo", "bar"));
    }
}
