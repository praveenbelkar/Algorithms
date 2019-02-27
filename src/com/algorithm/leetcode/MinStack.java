package com.algorithm.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    private static class Element {
        public int index;
        public Integer value;
    }

    private Stack<Element> stack;
    private Stack<Element> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        Element element = new Element();
        element.value = x;
        element.index = stack.size();

        if (isEmpty(minStack) || x < minStack.peek().value) {
            minStack.push(element);
        }
        stack.push(element);
    }

    private boolean isEmpty(Stack stack) {
        return stack.size() == 0;
    }

    public void pop() {
        if(isEmpty(stack)) {
            return;
        }
        if(stack.peek().index == minStack.peek().index) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return minStack.peek().value;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        //System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }
}
