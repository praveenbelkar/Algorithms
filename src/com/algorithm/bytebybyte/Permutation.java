package com.algorithm.bytebybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.byte-by-byte.com/permutations
 * Write a function which returns the permutations of a given list
 */
public class Permutation {

    public List<int []> listPermutation(int[] input){
        List<int []> results = new ArrayList<>();
        listPermutation(input, 0, results);
        return results;
    }

    private void listPermutation(int[] input, int start, List<int[]> results) {
        if(start >= input.length) {
            results.add(input.clone());
        } else {
            for(int i=start; i<input.length; i++){
                swap(input, start, i);
                listPermutation(input,start+1, results);
                swap(input, start,i);
            }
        }
    }

    private void swap(int[] input, int start, int i) {
        Integer temp = input[start];
        input[start] = input[i];
        input[i] = temp;
    }

    public static void main(String[] args) {
        Permutation mainObject = new Permutation();
        int[] input = {1,2,3,4};
        List<int []> results = mainObject.listPermutation(input);
        for(int[] result: results){
            Arrays.stream(result).forEach(element -> System.out.print(element + " "));
            System.out.println();
        }
        System.out.println("list size: " + results.size());
    }
}
