package com.algorithm.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 *
 *
 * Example 1:
 *
 * Input: "())"
 * Output: 1
 * Example 2:
 *
 * Input: "((("
 * Output: 3
 * Example 3:
 *
 * Input: "()"
 * Output: 0
 * Example 4:
 *
 * Input: "()))(("
 * Output: 4
 */
public class P921_MinimumAddParenthesisValid {

    public int minAddToMakeValid(String S) {
        if(null == S || S.trim().length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int inValidCount = 0;
        for(int i=0; i < S.length(); i++) {
            Character element = S.charAt(i);
            if(element == '(') {
                stack.push(element);
            } else if(element == ')') {
                if(stack.empty()) {
                    inValidCount++;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() + inValidCount;
    }

    public static void main(String[] args) {
        P921_MinimumAddParenthesisValid mainObject = new P921_MinimumAddParenthesisValid();
        String input1 = "())";
        System.out.println(mainObject.minAddToMakeValid(input1));

        String input2 = "()";
        System.out.println(mainObject.minAddToMakeValid(input2));

        String input3 = "(((";
        System.out.println(mainObject.minAddToMakeValid(input3));

        String input4 = "()))((";
        System.out.println(mainObject.minAddToMakeValid(input4));

    }
}
