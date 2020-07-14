package com.algorithm.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */
public class P1249_MinParenthesisRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        char[] inputChars = s.toCharArray();
        Set<Integer> lettersPositionToBeDeleted = new HashSet<>();
        for(int i=0; i < inputChars.length; i++) {
            char ch = inputChars[i];
            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                if(stack.size() <= 0) {
                    lettersPositionToBeDeleted.add(i);
                } else {
                    Integer poppedLetter = stack.pop();
                    System.out.println();
                }
            }
        }

        while (!stack.isEmpty()) {
            lettersPositionToBeDeleted.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < inputChars.length; i++) {
          if(!lettersPositionToBeDeleted.contains(i)) {
              sb.append(inputChars[i]);
          }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        P1249_MinParenthesisRemoveToMakeValid mainObject = new P1249_MinParenthesisRemoveToMakeValid();
        //String input = "lee(t(c)o)de)";
        //String input = "a)b(c)d";
        //String input = "))((";
        String input = "(a(b(c)d)";

        String result = mainObject.minRemoveToMakeValid(input);
        System.out.println(result);
    }
}
