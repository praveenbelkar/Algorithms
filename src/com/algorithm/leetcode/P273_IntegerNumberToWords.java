package com.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer to its english words representation.
 Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred
 Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred
 Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class P273_IntegerNumberToWords {

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }

        Map<String, String> map1 = initMap1();
        Map<String, String> map2 = initMap2();

        String numStr = String.valueOf(num);
        int numLength = numStr.length();
        StringBuilder sb = new StringBuilder();
        String magnitude = "";
        String digitsToBeProcessed = "";
        boolean isStart = true;
        String word = "";

        while(numStr.length() > 0) {
            int numberOfDigits = 3;
            if(isStart) {
                numberOfDigits = numLength % 3;
                if(numberOfDigits == 0) {
                    numberOfDigits = 3;
                }
                isStart = false;
            }
            digitsToBeProcessed = numStr.substring(0, numberOfDigits);
            magnitude = getMagnitude(numStr.length());
            numStr = numStr.substring(numberOfDigits);
            numberOfDigits = 3;
            word = getWord(digitsToBeProcessed, map1, map2);
            sb.append(word);
            if(word.length() > 0) {
                sb.append(magnitude);
            }

        }
        return sb.toString().trim();
    }

    private String getWord(String numStr, Map<String, String> map1, Map<String, String> map2) {
        StringBuilder sb = new StringBuilder();
        if(numStr.length() == 2) {
            numStr = "0" + numStr;
        }
        else if(numStr.length() == 1) {
            numStr = "00" + numStr;
        }
        for(int i=0; i < numStr.length(); i++) {
            if(i%3 == 0) {
                if(String.valueOf(numStr.charAt(i)).equals("0")) {
                    continue;
                }
                sb.append(map1.get(String.valueOf(numStr.charAt(i)))).append("Hundred ");
            } else if(i%3 == 1) {
                String currentChar = String.valueOf(numStr.charAt(i));
                if(String.valueOf(numStr.charAt(i)).equals("1")) {
                    String nextChar = String.valueOf(numStr.charAt(i+1));
                    currentChar = currentChar + nextChar;
                    sb.append(map1.get(currentChar));
                    return sb.toString();
                }
                if(currentChar.equals("0")) {
                    continue;
                }
                sb.append(map2.get(currentChar));
            } else {
                sb.append(map1.get(String.valueOf(numStr.charAt(i))));
            }
        }

        return sb.toString();
    }

    private boolean hasDigits(String numStr) {
        return false;
    }

    private String getMagnitude(int i) {
        if(i <= 3) {
            return " ";
        }

        if(i <= 6) {
            return "Thousand ";
        }
        if(i <= 9) {
            return "Million ";
        }
        if(i <= 12) {
            return "Billion ";
        }
        if(i <= 15) {
            return "Trillion ";
        }
        if(i <= 18) {
            return "Quadrillion ";
        }
        if(i <= 21) {
            return "Quintillion ";
        }
        return "empty";
    }

    private Map<String, String> initMap2() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "Twenty ");
        map.put("3", "Thirty ");
        map.put("4", "Forty ");
        map.put("5", "Fifty ");
        map.put("6", "Sixty ");
        map.put("7", "Seventy ");
        map.put("8", "Eighty ");
        map.put("9", "Ninety ");
        map.put("0", "");
        return map;
    }

    private Map<String, String> initMap1() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "");
        map.put("1", "One ");
        map.put("2", "Two ");
        map.put("3", "Three ");
        map.put("4", "Four ");
        map.put("5", "Five ");
        map.put("6", "Six ");
        map.put("7", "Seven ");
        map.put("8", "Eight ");
        map.put("9", "Nine ");
        map.put("10", "Ten ");
        map.put("11", "Eleven ");
        map.put("12", "Twelve ");
        map.put("13", "Thirteen ");
        map.put("14", "Fourteen ");
        map.put("15", "Fifteen ");
        map.put("16", "Sixteen ");
        map.put("17", "Seventeen ");
        map.put("18", "Eighteen ");
        map.put("19", "Nineteen ");
        return map;
    }

    public static void main(String[] args) {
        P273_IntegerNumberToWords mainObject = new P273_IntegerNumberToWords();
        int num = 23;
        System.out.println(num);
        //System.out.println(mainObject.numberToWords(num));

        num = 12345;
        System.out.println(num);
        //System.out.println(mainObject.numberToWords(num));

        num = 1345671;
        System.out.println(num);
        //System.out.println(mainObject.numberToWords(num));

        num = 12011;
        System.out.println(num);
        System.out.println(mainObject.numberToWords(num));

        num = 1000000;
        System.out.println(num);
        System.out.println(mainObject.numberToWords(num));

    }
}