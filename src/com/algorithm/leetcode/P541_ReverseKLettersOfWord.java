package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 */
public class P541_ReverseKLettersOfWord {

    public String reverseStr(String s, int k) {
        if(s == null || s.trim().length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(; i+2*k <= s.length()-1; i+=2*k) {
            String segment = s.substring(i,i+2*k);
            sb.append(reverse(segment,k));
        }
        if(s.length()-i <= k ) {
            String segment = s.substring(i);
            sb.append(reverse(segment,s.length()-i));
        } else if(s.length()-i > k && s.length()-i <= 2*k) {
            String segment = s.substring(i);
            sb.append(reverse(segment,k));
        }
        return sb.toString();
    }

    private String reverse(String segment, int k) {
        String part = segment.substring(0,k);
        char[] charStr = part.toCharArray();
        for(int i=0, j=charStr.length-1; i < j; i++, j--) {
            char temp = charStr[i];
            charStr[i] = charStr[j];
            charStr[j] = temp;
        }
        String reversedPart = new String(charStr);
        String retVal = reversedPart+segment.substring(k);
        return retVal;
    }

    public static void main(String[] args) {
        P541_ReverseKLettersOfWord mainObject = new P541_ReverseKLettersOfWord();
        //System.out.println(mainObject.reverseStr("abcdefg", 2));
        //System.out.println(mainObject.reverseStr("abcd", 2));
        System.out.println(mainObject.reverseStr("abc", 4));
    }
}
