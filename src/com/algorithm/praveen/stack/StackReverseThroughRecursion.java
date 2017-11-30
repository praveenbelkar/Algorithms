package com.algorithm.praveen.stack;

import java.util.Stack;

/**
 * Reverse the stack through recursion
 * @author Praveen Belkar
 *
 */
public class StackReverseThroughRecursion {
	
	public void reverse(Stack<Integer> stack) {
		int element =  Integer.MIN_VALUE;
		if(!stack.empty()) {
			element = stack.pop();
			reverse(stack);
			insertAtBottomOfStack(stack, element);
		}
	}
	
	public void insertAtBottomOfStack(Stack<Integer> stack, Integer element) {
		if(stack.isEmpty()) {
			stack.push(element);
			return;
		} else {
			Integer topElement = stack.pop();
			insertAtBottomOfStack(stack, element);
			stack.push(topElement);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
		StackReverseThroughRecursion mainObject = new StackReverseThroughRecursion();
		System.out.println(stack);
		mainObject.reverse(stack);
		System.out.println(stack);
	}
}
