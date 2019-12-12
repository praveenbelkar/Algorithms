package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class P299_BullsCowsNumberGuess {

    public String getHint(String secret, String guess) {
        if(null == secret || secret.length() == 0) {
            return "0A0B";
        } else if(null == guess || guess.length() == 0) {
            return "0A0B";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        boolean[] matchedPositions = new boolean[secret.length()];

        for(int i=0; i < secret.length(); i++) {
            matchedPositions[i] = false;
            Integer currentCount = charCount.get(secret.charAt(i));
            int cnt = 0;
            if(currentCount == null) {
                cnt = 1;
            } else {
                cnt = currentCount+1;
            }
            charCount.put(secret.charAt(i), cnt);
        }

        for(int i=0; i < guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                matchedPositions[i] = true;
                int cnt = charCount.get(secret.charAt(i));
                cnt = cnt - 1;
                if(cnt <= 0) {
                    charCount.remove(secret.charAt(i));
                } else {
                    charCount.put(secret.charAt(i), cnt);
                }
            }
        }

        for(int i=0; i < guess.length(); i++) {
            Integer currentCount = charCount.get(guess.charAt(i));
            if(matchedPositions[i] == true) {
                continue;
            }
            if(currentCount != null) {
                cows++;
                currentCount--;
                if(currentCount <= 0) {
                    charCount.remove(guess.charAt(i));
                } else {
                    charCount.put(guess.charAt(i), currentCount);
                }
            }
        }
        return bulls + "A" + cows + "B";

    }

    public static void main(String[] args) {
        P299_BullsCowsNumberGuess mainObject = new P299_BullsCowsNumberGuess();
        String secret = "1807";
        String guess = "7810";
        System.out.println(secret);
        System.out.println(guess);
        System.out.println(mainObject.getHint(secret, guess));
        System.out.println();

        secret = "1123";
        guess = "0111";
        System.out.println(secret);
        System.out.println(guess);
        System.out.println(mainObject.getHint(secret, guess));
        System.out.println();

        secret = "11";
        guess = "10";
        System.out.println(secret);
        System.out.println(guess);
        System.out.println(mainObject.getHint(secret, guess));
        System.out.println();

        secret = "1122";
        guess = "1222";
        System.out.println(secret);
        System.out.println(guess);
        System.out.println(mainObject.getHint(secret, guess));
    }
}
