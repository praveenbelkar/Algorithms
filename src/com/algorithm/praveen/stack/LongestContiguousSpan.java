package com.algorithm.praveen.stack;

import java.util.Stack;

public class LongestContiguousSpan {

    public int[] getMaxContinuousSpan(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        int count = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] > stack.pop()) {
                stack.push(input[i]);
                count++;
                result[i] = count;
            } else {
                emptyStack(stack);
                stack.push(input[i]);
                count = 1;
                result[i] = count;
            }
        }

        return result;
    }

    private void emptyStack(Stack<Integer> stack) {
        while(stack.size() != 0) {
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] input = {6,3,4,5,2,3,4,5,6,4};
        LongestContiguousSpan mainObject = new LongestContiguousSpan();
        int[] result = mainObject.getMaxContinuousSpan(input);
        for(Integer element : result) {
            System.out.println(element);
        }

    }
}
