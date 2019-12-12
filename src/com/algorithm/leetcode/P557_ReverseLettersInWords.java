package com.algorithm.leetcode;


/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class P557_ReverseLettersInWords {

    public String reverseWords(String s) {
        if(s == null || s.trim().length() == 0) {
            return s;
        }

        String[] wordsArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean firstWord = true;
        for(String word: wordsArray) {
            System.out.println(word);
            if(firstWord) {
                sb.append(reverse(word));
                firstWord = false;
            } else {
                sb.append(" ").append(reverse(word));
            }

        }
        return sb.toString();
    }

    private String reverse(String word) {
        char[] charWord = word.toCharArray();
        for(int i=0, j=charWord.length-1; i < j; i++, j--) {
            char temp = charWord[i];
            charWord[i]=charWord[j];
            charWord[j]=temp;
        }

        String newWord = new String(charWord);
        return newWord;
    }

    public static void main(String[] args) {
        P557_ReverseLettersInWords mainObject = new P557_ReverseLettersInWords();
        System.out.println(mainObject.reverseWords("Let's take LeetCode contest"));
    }
}
