package com.algorithm.praveen.strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramDiff {

    public int anagram(String s) {

        if(s == null || s.length() == 0 || s.length() % 2 == 1) {
            return -1;
        }

        String s2 = s.substring(s.length()/2);
        s = s.substring(0, s.length()/2);
        System.out.println(s);
        System.out.println(s2);
        Map<Character, Integer> countMap1 = new HashMap<>();
        Map<Character, Integer> countMap2 = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
            Integer currentCharCount = countMap1.get(s.charAt(i));
            if(currentCharCount == null || currentCharCount == 0) {
                currentCharCount = 1;
            } else {
                currentCharCount++;
            }
            countMap1.put(s.charAt(i), currentCharCount);
        }

        for(int i=0; i < s2.length(); i++) {
            Integer currentCharCount = countMap2.get(s2.charAt(i));
            if(currentCharCount == null || currentCharCount == 0) {
                currentCharCount = 1;
            } else {
                currentCharCount++;
            }
            countMap2.put(s2.charAt(i), currentCharCount);
        }

        int sum = 0;
        for(Map.Entry<Character, Integer> entry1: countMap1.entrySet()) {
            int count1 = countMap2.get(entry1.getKey()) == null ? 0: countMap2.get(entry1.getKey());
            int diff1 =  count1 - entry1.getValue();
            if(diff1 > 0) {

            } else {

            }
            countMap2.remove(entry1.getKey());
        }

        for(Map.Entry<Character, Integer> entry2: countMap2.entrySet()) {
            int count2 = countMap2.get(entry2.getKey()) == null ? 0: countMap2.get(entry2.getKey());
            //sum = sum + count2;
            countMap2.remove(entry2.getKey());
        }

        int count  = Math.max(countMap1.size(), countMap2.size());
        return count;
    }

    public static void main(String[] args) {
        AnagramDiff mainObject = new AnagramDiff();
        System.out.println(mainObject.anagram("xaxbbbxx"));
    }

}
