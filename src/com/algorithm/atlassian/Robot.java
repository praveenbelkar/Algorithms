package com.algorithm.atlassian;

import java.util.Stack;

public class Robot {

    static String compute(String instructions) {

        Stack<Character> stack = new Stack<>();
        if(instructions == null || instructions.trim().length() == 0) {
            return "";
        }

        int row = 0;
        int[] stash = new int[10];
        for(int i=0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'P':
                    if(!stack.isEmpty()) {
                        row = 0;
                    } else {

                    }
                    stack.push('P');
                    break;

                case 'M':
                    if(row < 9){
                        row++;
                    }
                    stack.push('M');
                    break;

                case 'L':
                    if(stash[row] < 15 /*&& stackContainsM(stack)*/) {
                        stash[row]++;
                    }

                    empty(stack);
                    row=0;
                    break;
                    
                    default:
                        break;
                        

            }
        }

        return getOutput(stash);

    }

    private static boolean stackContainsM(Stack<Character> stack) {
        while(!stack.isEmpty()) {
            if('M' == stack.pop()) {
                return true;
            }
        }
        return false;
    }

    private static String getOutput(int[] stash) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < stash.length; i++) {
            sb.append(Integer.toHexString(stash[i]).toUpperCase());
        }
        return sb.toString();
    }

    private static void empty(Stack<Character> stack) {
        while(!stack.isEmpty()) {
            stack.pop();
        }
    }


    public static void main(String[] args) {
        System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));
    }
}
