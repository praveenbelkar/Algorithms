package com.algorithm.praveen.arrays;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Rearrange the array containing {0,1,2} such that 0's appear at the start of the array, later 1's appear, and 2's appear in the end
 */
public class DutchNationalFlag {

    public int[] rearrange(int[] input) {
        int low = 0;
        int mid = 0;
        int high = input.length-1;

        while(mid < high){
            switch (input[mid]) {
                case 0:
                    swap(input, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(input, mid, high);
                    high--;
            }
        }
        return input;
    }

    private void swap(int[] input, int position1, int position2) {
        int temp = input[position1];
        input[position1] = input[position2];
        input[position2] = temp;
    }

    public static void main(String[] args) {
        DutchNationalFlag mainObject = new DutchNationalFlag();
        int[] input = {2,1,0,0,2,1,1,2,0};
        input = mainObject.rearrange(input);
        Arrays.stream(input).forEach(element -> System.out.print(element + " "));
    }
}
