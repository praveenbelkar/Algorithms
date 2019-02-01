package com.algorithm.leetcode;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea mainObject = new LargestRectangleArea();
        int[] heights = {4,2,1};//{2, 1, 5, 6, 2, 3};

        System.out.println(mainObject.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int height = heights[top];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int currentArea = height * width;
                maxArea = Math.max(currentArea, maxArea);
            }
        }


        while (!stack.isEmpty()) {
            int top = stack.pop();
            int height = heights[top];
            int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
            int currentArea = height * width;
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }
}
