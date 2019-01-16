package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class RainWaterTrapping {

    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        //Calculate for each tower, the maximum height of the tower on its right side
        int[] rightMax = calculateRightMax(height);

        //Calculate for each tower, the maximum height of the tower on its left side
        //For each tower, the maximum water it can trap on itself is
        //Min(maxHeightOnLeftForThatTower, maxHeightOnRightForThatTower) - current tower height

        //For the first tower and last tower, no water trapping is possible
        int maxBeforeCurrentElement = height[0];
        int sum = 0;
        for(int i= 1; i < height.length-1; i++) {
            if(height[i] < maxBeforeCurrentElement && rightMax[i] > 0) {
                int temp = Math.min(maxBeforeCurrentElement, rightMax[i]);
                sum = sum + (temp - height[i]);
                //System.out.print((temp - height[i]) + " ");
            }else{
                maxBeforeCurrentElement = height[i];
            }
            System.out.print(maxBeforeCurrentElement + " ");
        }
        System.out.println();
        return sum;
    }

    private int[] calculateRightMax(int[] height) {
        int[] rightMax = new int[height.length];
        Arrays.fill(rightMax, -1);

        rightMax[height.length-1] = -1;
        int maxBeforeCurrentElement = height[height.length-1];

        for(int i=height.length-2; i >= 0; i--) {
            if(height[i] < maxBeforeCurrentElement) {
                rightMax[i] = maxBeforeCurrentElement;
            }else{
                maxBeforeCurrentElement = height[i];
            }
        }
        System.out.println("rightMax: "+Arrays.toString(rightMax));
        return rightMax;
    }

    public static void main(String[] args) {
        RainWaterTrapping mainObject = new RainWaterTrapping();
        //int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] input = {1,5,2,3,1,7,2,4};
        int[] input = {};

        System.out.println("input:    " + Arrays.toString(input));
        System.out.println(mainObject.trap(input));
    }
}
