package com.algorithm.bytebybyte;

import java.util.Arrays;

/**
 * https://www.byte-by-byte.com/mergearrays
 * Given 2 sorted arrays, A and B, where A is long enough to hold the contents of A and B,
 * write a function to copy the contents of B into A without using any buffer or additional memory.
 *
 * A = {1,3,5,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE}
 B = {2,4,6}
 mergeArrays(A, B)
 A = {1,2,3,4,5,6}
 */
public class MergeArrays {

    public int[] mergeArrays(int[] input1, int[] input2) {
        //Get the number of elements in bigger array i.e. input1
        int numberOfElementsInBiggerArray= 0;
        for(int i=0; i < input1.length; i++) {
            if(input1[i] == Integer.MIN_VALUE){
                numberOfElementsInBiggerArray = i;
                break;
            }
        }

        int index1 = numberOfElementsInBiggerArray-1;
        int index2 = input2.length-1;
        int targetIndex = input1.length-1;
        while(index1 >=0 && index2 >= 0) {
            if(input1[index1] > input2[index2]) {
                input1[targetIndex--] = input1[index1--];
            }else{
                input1[targetIndex--] = input2[index2--];
            }
        }

        if(index1 >= 0){
            while(index1 >= 0){
                input1[targetIndex--] = input1[index1--];
            }
        }

        if(index2 >= 0){
            while(index2 >= 0){
                input1[targetIndex--] = input2[index2--];
            }
        }

        return input1;
    }

    public static void main(String[] args) {
        MergeArrays mainObject = new MergeArrays();
        int[] input1 = {1,3,5,Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] input2 = {2,4,6};
        mainObject.mergeArrays(input1, input2);
        Arrays.stream(input1).forEach(element -> System.out.print(element + " "));
    }
}
