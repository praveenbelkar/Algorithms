package com.algorithm.praveen.sorting;

public class MergeSort {

    public void mergeSort(int[] input, int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;
            mergeSort(input, low, mid);
            mergeSort(input, mid+1, high);
            merge(input, low, mid, high);
        }
    }

    private void merge(int[] input, int low, int mid, int high) {
        int lSize = mid - low + 1;
        int rSize = high - mid;
        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];
        for(int i=0; i < lSize; i++) {
            lArray[i] = input[low + i];
        }
        for(int i=0; i < rSize; i++) {
            rArray[i] = input[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while(i < lSize && j < rSize) {
            if(lArray[i] <= rArray[j]) {
                input[k++] = lArray[i++];
            } else {
                input[k++] = rArray[j++];
            }
        }

        while(i < lSize) {
            input[k++] = lArray[i++];
        }
        while(j < rSize) {
            input[k++] = rArray[j++];
        }
    }

    private void printArray(int[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void main(String[] args) {
        MergeSort mainObject = new MergeSort();
        int[] input = {12, 11, 13, 5, 6, 7};
        mainObject.mergeSort(input, 0, input.length-1);
        mainObject.printArray(input);
    }
}
