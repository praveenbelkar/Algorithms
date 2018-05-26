package com.algorithm.praveen.dynamicprogram;

public class ShortestPalindrome {

    public boolean isPalindrome(String input) {
        for(int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            if(input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public String getShortestPalindromeByPrefixing(String input) {
        for(int j= 0; j < input.length(); j++) {
            String suffix = input.substring(input.length() - j);
            String revereSuffix = reverse(suffix);
            String newInput = revereSuffix + input;
            System.out.println(newInput);
            if(isPalindrome(newInput)) {
                return newInput;
            }
        }
        return null;
    }

    private String reverse(String input) {
        char[] chars = input.toCharArray();
        for(int i=0, j=chars.length-1; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ShortestPalindrome mainObject = new ShortestPalindrome();
        System.out.println(mainObject.getShortestPalindromeByPrefixing("abcd"));
    }
}
