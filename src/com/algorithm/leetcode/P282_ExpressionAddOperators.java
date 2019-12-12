package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class P282_ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        List<String> currentOpsList = new ArrayList<>();
        addOperators(num, target, results, currentOpsList);
        return results;
    }

    private boolean addOperators(String num, int target, List<String> results, List<String> currentOpsList) {
        if(num == null || num.length() == 0) {
            return true;
        }
        int digit = Integer.parseInt(num);
        if(digit == target) {
            currentOpsList.add(String.valueOf(digit));
            String ops = getStringFromList(currentOpsList);
            results.add(ops);
            return true;
        }
        for(int i=0; i < num.length(); i++) {
            String firstPart = num.substring(0, i+1);
            String secondPart = num.substring(i+1);
            int firstI = Integer.parseInt(firstPart);
            //int secondI = Integer.parseInt(secondPart);
            int newTarget = target - firstI;
            currentOpsList.add(firstPart);
            currentOpsList.add("+");
            addOperators(secondPart, newTarget, results, currentOpsList);
            currentOpsList.remove(currentOpsList.size()-1);
            currentOpsList.remove(currentOpsList.size()-1);

            int mod = target % firstI;
            if(mod == 0) {
                newTarget = target / firstI;
                currentOpsList.add(firstPart);
                currentOpsList.add("*");
                addOperators(secondPart, newTarget, results, currentOpsList);
                currentOpsList.remove(currentOpsList.size()-1);
                currentOpsList.remove(currentOpsList.size()-1);
            }

            //newTarget = firstI - target;


        }
        return false;
    }

    private String getStringFromList(List<String> currentOpsList) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < currentOpsList.size(); i++) {
            sb.append(currentOpsList.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P282_ExpressionAddOperators mainObject = new P282_ExpressionAddOperators();
        String num = "232";
        int target = 8;
        List<String> results = mainObject.addOperators(num, target);
        printList(results);
    }

    private static void printList(List<String> results) {
        results.stream().forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
