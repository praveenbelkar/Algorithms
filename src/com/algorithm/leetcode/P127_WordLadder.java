package com.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 */
public class P127_WordLadder {

    public int ladderLengthUtil(String beginWord, String endWord, List<String> wordList, Map<String, Integer> cache, Map<String, Boolean> visited) {

        String key = beginWord + endWord;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        if(beginWord.equals(endWord)) {
            return 0;
        }

        if(differByOneLetter(beginWord, endWord)) {
            return 1;
        }
        visited.put(endWord, true);

        Set<String> wordsDifferingByOneLetter = getWordsInDictionaryWhichDifferByOneLetter(endWord, wordList, visited);
        if(wordsDifferingByOneLetter.size() == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        for(String word: wordsDifferingByOneLetter) {
            int temp = ladderLengthUtil(beginWord, word, wordList, cache, visited);
            if(temp > 0) {
                minLength = Math.min( minLength, temp);
            }
        }

        if(minLength == Integer.MAX_VALUE) {
            return 0;
        }
        minLength = 1 + minLength;
        cache.put(key, minLength);
        return minLength;
    }

    private Set<String> getWordsInDictionaryWhichDifferByOneLetter(String endWord, List<String> wordList, Map<String, Boolean> visited) {
        return wordList.stream().filter(word -> !visited.containsKey(word) && differByOneLetter(endWord, word)).collect(Collectors.toSet());
    }

    private boolean differByOneLetter(String word1, String word2) {
        int count = 0;
        for(int i=0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1 ;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> cache = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }
        int result = ladderLengthUtil(beginWord, endWord, wordList, cache, visited);
        return result > 0 ? result + 1: result;
    }

    public static void main(String[] args) {
        P127_WordLadder mainObject = new P127_WordLadder();
/*
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
*/

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        //List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        //List<String> wordList = Arrays.asList("hot","dot","tog","cog");

        System.out.println(mainObject.ladderLength(beginWord, endWord, wordList));
    }

}
