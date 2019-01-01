package com.algorithm.praveen.sorting;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int[] input) {
        for(int i = 0; i < input.length-1; i++) {
            int smallestIndex = getSmallestIndex(input, i);
            swap(input, i, smallestIndex);
        }
    }

    private void swap(int[] input, int first, int second) {
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

    private int getSmallestIndex(int[] input, int startIndex) {
        int smallest = startIndex;
        for(int i = startIndex; i < input.length; i++) {
            if(input[smallest] > input[i]) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        SelectionSort mainObject = new SelectionSort();
        int[] input = {1,8,2,5,4,6};
        mainObject.selectionSort(input);
        Arrays.stream(input).forEach(System.out::println);
    }
}
