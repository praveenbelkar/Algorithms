package com.algorithm.praveen.sorting;

import java.util.stream.StreamSupport;

public class QuickSort {

    public void quickSort(int[] input, int low, int high) {
        if(low < high) {
            int pivot = partition(input, low, high);
            quickSort(input, low, pivot - 1);
            quickSort(input, pivot +1, high);
        }
    }

    private int partition(int[] input, int low, int high) {
        int i = low + 1;
        int j = high;
        int pivot = input[low];
        while (true) {
            while(i <= high && input[i] <= pivot) {
                i++;
            }
            while (j > 0 && input[j] > pivot) {
                j--;
            }
            if(i < j) {
                swap(input, i, j);
            } else {
                swap(input, low, j);
                break;
            }
        }
        return j;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private void printArray(int[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
    public static void main(String[] args) {
        QuickSort mainObject = new QuickSort();
        int[] input = {10, 7, 8, 9, 1, 5}; //{10, 80, 30, 90, 40, 50, 70};
        mainObject.quickSort(input, 0, input.length - 1);
        mainObject.printArray(input);
    }
}
