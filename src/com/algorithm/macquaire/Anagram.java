package com.algorithm.macquaire;

import java.util.*;

public class Anagram {
    public static boolean areAnagrams(String str1, String str2) {
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

    public static List<String> funWithAnagrams(List<String> s) {
        List<String> inputList = new ArrayList<String>(s);
        // Write your code here
        if(inputList == null || inputList.size() == 0) {
            return inputList;
        }
        String[] input = new String[inputList.size()];
        int k = 0;
        for(String element: inputList) {
            input[k] = element;
            k++;
        }

        List<String> result = new ArrayList<>();
        Set<Integer> excludeIndex = new HashSet<>();
        for(int i=0; i < input.length; i++) {
            for(int j=0; j < input.length; j++) {
                if(i == j) {
                    continue;
                }
                if(excludeIndex.contains(j) || excludeIndex.contains((i))) {
                    continue;
                }
                if(areAnagrams(input[i], input[j])) {
                    inputList.remove(input[j]);
                   excludeIndex.add(j);
                }
            }
        }
        Collections.sort(inputList);
        return inputList;
    }

    public static void main(String[] args) {
        List<String> s = Arrays.asList("code", "aaagmnrs", "anagrams", "doce");
        List<String> result = funWithAnagrams(s);
        result.forEach(element -> System.out.print(element + " "));
    }
}
