package com.algorithm.bytebybyte;

import java.util.Stack;

/**
 * Reverse a given stack without creating any additional data structures
 */
public class ReverseStack {
    public void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        Integer topElement = stack.pop();
        reverse(stack);
        insertAtBotton(stack, topElement);
    }

    private void insertAtBotton(Stack<Integer> stack, Integer element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }
        Integer topElement = stack.pop();
        insertAtBotton(stack, element);
        stack.push(topElement);
    }

    public static void main(String[] args) {
        ReverseStack mainObject = new ReverseStack();
        Stack<Integer> stack;
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        mainObject.printStack(stack);
        System.out.println("----------------");
        mainObject.reverse(stack);
        System.out.println("----------------");
        mainObject.printStack(stack);
    }

    private void printStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
           return;
        }
        Integer element = stack.pop();
        System.out.print(element + " ");
        printStack(stack);
        stack.push(element);
    }
}
