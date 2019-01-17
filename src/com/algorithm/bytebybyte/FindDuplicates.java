package com.algorithm.bytebybyte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.byte-by-byte.com/findduplicates
 * Given an array of integers where each value 1 <= x <= len(array),
 * write a function that finds all the duplicates in the array.
 *
 dups([1, 2, 3])    = []
 dups([1, 2, 2])    = [2]
 dups([3, 3, 3])    = [3]
 dups([2, 1, 2, 1]) = [1, 2]
 */

public class FindDuplicates {

    public Set<Integer> findDuplicates(int[] input){
        Set<Integer> result = new HashSet<>();
        for(int i=0; i<input.length; i++){
            int index = Math.abs(input[i])-1;
            if(input[index] < 0) {
                result.add(Math.abs(input[i]));
            }else{
                input[index] = -input[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDuplicates mainObject = new FindDuplicates();
        int[] input = {3,3,3};
        System.out.println(mainObject.findDuplicates(input));
    }
}
