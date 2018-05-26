package com.algorithm.praveen.dynamicprogram;

import java.util.HashSet;
import java.util.Set;

//Given a dictionary of words and a string of characters, find if the string of characters can be broken into individual valid words from the dictionary.
//Example:
//Dictionary: arrays, dynamic, heaps, IDeserve,  learning, linked, list, platform, programming, stacks, trees
//String    : IDeservelearningplatform
//Output   : true
//Because the string can be broken into valid words: IDeserve learning platform
public class WordBreak {
    private static Set<String> dictionary = new HashSet<>();
    public static void buildDictionary(String[] words) {
        for(String word : words) {
            dictionary.add(word);
        }
    }

    public void wordBreakCheck(int startIndex, String input, boolean[] flagArray) {
        for(int i=startIndex; i < input.length(); i++) {
            String subStringEndingHere = input.substring(startIndex,i+1);
            if(dictionaryContains(subStringEndingHere)) {
                System.out.println(subStringEndingHere);
                flagArray[i] = true;
                wordBreakCheck(i+1, input, flagArray);
                break;
            }
        }
    }

    private boolean dictionaryContains(String word) {
        return dictionary.contains(word);
    }

    public boolean wordBreakCheck(String input) {
        boolean[] flagArray = new boolean[input.length()];
        for(Boolean flag: flagArray) {
            flag = false;
        }
        wordBreakCheck(0, input, flagArray);
        return flagArray[input.length()-1];
    }

    public static void main(String[] args) {
        WordBreak mainObject = new WordBreak();
        WordBreak.buildDictionary(new String[]{"arrays", "dynamic", "heaps", "IDeserve", "learning", "linked", "list", "platform", "programming", "stacks", "trees"});
        boolean result = mainObject.wordBreakCheck("IDeservelearningplatform");
        System.out.println(result);
    }
}
