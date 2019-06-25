package com.algorithm.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class P20_ValidParenthesis {

    public boolean isValid(String s) {
        if(s == null || s.trim().length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            Character poppedElement;
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(s.charAt(i));
                    break;

                case '}':
                    if(stack.empty()) {
                        return false;
                    }
                    poppedElement = stack.pop();
                    if(poppedElement != '{')
                        return false;
                    break;
                case ']':
                    if(stack.empty()) {
                        return false;
                    }
                    poppedElement = stack.pop();
                    if(poppedElement != '[')
                        return false;
                    break;
                case ')':
                    if(stack.empty()) {
                        return false;
                    }
                    poppedElement = stack.pop();
                    if(poppedElement != '(')
                        return false;
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        P20_ValidParenthesis mainObject = new P20_ValidParenthesis();

        String input1 = "()";
        System.out.println(mainObject.isValid(input1));

        String input2 = "()[]{}";
        System.out.println(mainObject.isValid(input2));

        String input3 = "(]";
        System.out.println(mainObject.isValid(input3));

        String input4 = "([)]";
        System.out.println(mainObject.isValid(input4));

        String input5 = "{[]}";
        System.out.println(mainObject.isValid(input5));

        String input6 = "]";
        System.out.println(mainObject.isValid(input6));

        String input7 = "[";
        System.out.println(mainObject.isValid(input6));
    }
}
