package com.algorithm.praveen.sorting;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] input) {
        for(int i = input.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(input[j] > input[j+1]) {
                    swap(input, j, j+1);
                }
            }
        }
    }

    private void swap(int[] input, int j, int k) {
        int temp = input[j];
        input[j] = input[k];
        input[k] = temp;
    }

    public static void main(String[] args) {
        BubbleSort mainObject = new BubbleSort();
        int[] input = {1,8,2,5,4,6};
        mainObject.bubbleSort(input);
        Arrays.stream(input).forEach(System.out::println);
    }
}
