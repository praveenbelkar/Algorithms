package com.algorithm.praveen.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Get the maximum value in the each possible sliding window of size k, in an array
 */
public class SlidingWindow {
    public void addToSlidingWindowMaxList(LinkedList<Integer> slidingWindow, int element) {
        while(slidingWindow.size() > 0 && element >= slidingWindow.getLast()) {
            slidingWindow.removeLast();
        }
        slidingWindow.addLast(element);
        System.out.println(slidingWindow.getFirst() + "  " + slidingWindow);
    }

    public void printSlidingWindowMax(int[] input, int k) {
        LinkedList<Integer> slidingWindowList = new LinkedList<>();
        for(int i=0; i < k && i < input.length; i++) {
            addToSlidingWindowMaxList(slidingWindowList, input[i]);
        }

        for(int j=k; j < input.length; j++) {
            if(slidingWindowList.getFirst() == input[j]) {
                slidingWindowList.removeFirst();
            }
            addToSlidingWindowMaxList(slidingWindowList, input[j]);
        }
    }

    public static void main(String[] args) {
        SlidingWindow mainObject = new SlidingWindow();
        int[] input = {9,6,11,8,10,5,14,13,93,14};
        int k = 4;
        mainObject.printSlidingWindowMax(input, k);
    }
}
