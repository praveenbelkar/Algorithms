package com.algorithm.praveen.recursion;

public class Palindrome {

    public boolean checkPalindromeRecursive(String input, int start, int end) {
        if(start <= end) {
            if(input.charAt(start) != input.charAt(end)) {
                return false;
            }
            return checkPalindromeRecursive(input, start+1, end-1);
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome mainObject = new Palindrome();
        String input = "abda";
        System.out.println(mainObject.checkPalindromeRecursive(input,0, input.length()-1));
    }
}
