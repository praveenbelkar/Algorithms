package com.algorithm.bytebybyte;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.byte-by-byte.com/anagrams
 * Given two strings, write a function to determine whether they are anagrams.
 */
public class Anagrams {

    public boolean areAnagrams(String str1, String str2) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            Integer count = charCount.get(str1.charAt(i));
            count = (count == null)? 1: (count+1);
            charCount.put(str1.charAt(i), count);
        }

        for(int i=0; i<str2.length(); i++){
            Integer count = charCount.get(str2.charAt(i));
            if(null == count) {
                return false;
            }
            if(count == 1) {
                charCount.remove(str2.charAt(i));
            } else{
                charCount.put(str2.charAt(i), (count-1));
            }
        }

        return (charCount.size() == 0);
    }

    public static void main(String[] args) {
        Anagrams mainObject = new Anagrams();
        String str1 = "abcd";
        String str2 = "cbad";
        System.out.println(mainObject.areAnagrams(str1, str2));
    }
}
