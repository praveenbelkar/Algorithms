package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * Input:
 [
 ["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]
 ]
 Output: 6
 */
public class MaximumRectangleArea {

    private LargestRectangleArea largestRectangleArea = new LargestRectangleArea();

    public int maximalRectangle(char[][] matrix) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] prev = new int[matrix[0].length];
        for(int i=0; i < matrix.length; i++) {
            int[] cur = new int[matrix[0].length];

            Arrays.fill(cur, 0);
            if(i==0) {
                cur = getRowArray(matrix[0]);
                prev = cur;
                Arrays.stream(cur).forEach( element -> System.out.println(element + " "));
                System.out.println();
                maxArea = largestRectangleArea(cur);
                continue;
            }

            //temp = getRowArray(matrix[i-1]);
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == '0') {
                    cur[j] = 0;
                } else {
                    //cur[j] = getIntValue(matrix[i-1][j]) + 1;
                    cur[j] = prev[j] + 1;
                }
            }
            prev = cur;
            Arrays.stream(cur).forEach( element -> System.out.println(element + " "));
            System.out.println();
            int area = largestRectangleArea(cur);
            maxArea = Math.max(maxArea, area);


        }

        return maxArea;
    }

    private int getIntValue(char ch) {
        return ch == '0' ? 0 : 1;
    }

    private int[] getRowArray(char[] matrix) {
        int[] temp = new int[matrix.length];
        for(int i=0; i < temp.length; i++) {
            temp[i] = getIntValue(matrix[i]);
        }
        return temp;
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

    public static void main(String[] args) {
        MaximumRectangleArea mainObject = new MaximumRectangleArea();
        char[][] input = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        /*input = new char[][]{
                {'1'}
        };*/

        /*input = new char[][]{
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','1','1'}
        };*/
        System.out.println(mainObject.maximalRectangle(input));
    }
}
