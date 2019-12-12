package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class P17_LetterCombinationPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.trim().length() == 0) {
            return new ArrayList<>();
        }
        Map<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r", "s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});

        List<String> result = letterCombinationsUtil(digits, 0, map);
        return result;
    }

    private List<String> letterCombinationsUtil(String digits, int currentIndex, Map<String, String[]> map) {
        List<String> currentSetResult = new ArrayList<>();
        if(currentIndex > digits.length() - 1) {
            return currentSetResult;
        }


        List<String> nextSetResult = letterCombinationsUtil(digits, currentIndex+1, map);
        String[] lettersMappedToCurrentIndex = map.get(String.valueOf(digits.charAt(currentIndex)));
        for(int i=0; i < lettersMappedToCurrentIndex.length; i++) {
            String letter = lettersMappedToCurrentIndex[i];
            if(nextSetResult.isEmpty()){
                currentSetResult.add(letter);
            } else {
                for(String element: nextSetResult) {
                    String result = letter + element;
                    currentSetResult.add(result);
                }
            }
        }
        return currentSetResult;
    }

    public static void main(String[] args) {
        P17_LetterCombinationPhoneNumber mainObject = new P17_LetterCombinationPhoneNumber();
        List<String> result = mainObject.letterCombinations("23");
        for(String element: result) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
