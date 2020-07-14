package com.algorithm.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 */
public class P856_ScoreOfParenthesis {

    public int scoreOfParentheses(String S) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if(S.charAt(i) == ')') {
                Character stackPoppedElement = stack.pop();
                if(stackPoppedElement == '(') {
                    stack.push('1');
                    continue;
                } else {
                    Character poppedElement = stack.pop();
                    Integer newElementToBePushed = 0;
                    if(poppedElement == '(') {
                        newElementToBePushed = 2 * Character.getNumericValue(stackPoppedElement);
                    } else {
                        newElementToBePushed = Character.getNumericValue(stackPoppedElement) + Character.getNumericValue(poppedElement);
                    }
                    stack.push(Character.forDigit(newElementToBePushed, 10));
                }
            }
        }

        if(stack.size() == 1) {
            Character result =  stack.pop();
            Integer intResult = Character.getNumericValue(result);
            return intResult;
        }

        while(!stack.isEmpty()) {
            if(stack.size() == 1) {
                break;
            }
            Character firstPoppedElement = stack.pop();
            Character secondPoppedElement = stack.pop();
            Integer newElementToBePushed = 0;
            if(secondPoppedElement == '(') {
                newElementToBePushed = 2 * Character.getNumericValue(firstPoppedElement);
            } else {
                newElementToBePushed = Character.getNumericValue(firstPoppedElement) + Character.getNumericValue(secondPoppedElement);
            }
            stack.push(Character.forDigit(newElementToBePushed, 10));
        }

        Character result =  stack.pop();
        int intResult = Character.getNumericValue(result);;
        return intResult;
    }

    public static void main(String[] args) {
        P856_ScoreOfParenthesis mainObject = new P856_ScoreOfParenthesis();
/*
        System.out.println(mainObject.scoreOfParentheses("(()(()))"));
        System.out.println(mainObject.scoreOfParentheses("()"));
        System.out.println(mainObject.scoreOfParentheses("(())"));
        System.out.println(mainObject.scoreOfParentheses("()()"));
*/
        System.out.println(mainObject.scoreOfParentheses("(()())()"));

    }
}
