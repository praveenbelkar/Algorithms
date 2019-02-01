package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string, reverse the string word by word.
 Example:
 Input: "the sky is blue",
 Output: "blue is sky the".
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if(null == s || s.trim().length() == 0){
            return "";
        }
        s =s.trim();
        String[] wordsArray = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=wordsArray.length-1; i>=0; i--){
            if(i != wordsArray.length-1) {
                sb.append(" ");
            }
            sb.append(wordsArray[i].trim());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords mainObject = new ReverseWords();
        System.out.println(mainObject.reverseWords("the sky   is blue"));
        System.out.print("**");
        System.out.print(mainObject.reverseWords(" 1"));
        System.out.println("**");
    }
}
