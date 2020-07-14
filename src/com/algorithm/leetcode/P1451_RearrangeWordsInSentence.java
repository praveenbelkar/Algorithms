package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 *
 * Given a sentence text (A sentence is a string of space-separated words) in the following format:
 *
 * First letter is in upper case.
 * Each word in text are separated by a single space.
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.
 *
 * Return the new text following the format shown above.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "Leetcode is cool"
 * Output: "Is cool leetcode"
 * Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
 * Output is ordered by length and the new first word starts with capital letter.
 * Example 2:
 *
 * Input: text = "Keep calm and code on"
 * Output: "On and keep calm code"
 * Explanation: Output is ordered as follows:
 * "On" 2 letters.
 * "and" 3 letters.
 * "keep" 4 letters in case of tie order by position in original text.
 * "calm" 4 letters.
 * "code" 4 letters.
 * Example 3:
 *
 * Input: text = "To be or not to be"
 * Output: "To be or to be not"
 */
public class P1451_RearrangeWordsInSentence {

    public static class Word {
        public String textValue;
        public int position;
        public int length;
    }

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        List<Word> wordsList = new ArrayList<>();
        for(int i=0; i < words.length; i++) {
            Word newWord = new Word();
            newWord.textValue = words[i].toLowerCase();
            newWord.position = i;
            newWord.length = words[i].length();
            wordsList.add(newWord);
        }
        wordsList.sort((word1, word2) -> {
            if(word1.length != word2.length){
                return word1.length - word2.length;
            }
            return word1.position - word2.position;
        });


        String word1 = wordsList.get(0).textValue;
        String firstLetterOfFirstWord = word1.substring(0,1).toUpperCase();
        String otherLettersOfFirstWord = word1.substring(1);

        StringBuilder sb = new StringBuilder(firstLetterOfFirstWord);
        sb.append(otherLettersOfFirstWord);

        for(int i=1; i < wordsList.size(); i++) {
            sb.append(" ");
            sb.append(wordsList.get(i).textValue);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        P1451_RearrangeWordsInSentence mainObject = new P1451_RearrangeWordsInSentence();
        //String input = "Keep calm and code on";
        String input = "To be or not to be";
        String result = mainObject.arrangeWords(input);
        System.out.println(result);
    }
}
