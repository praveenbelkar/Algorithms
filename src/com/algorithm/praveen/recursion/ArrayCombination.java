package com.algorithm.praveen.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Get the list of all possible combination of an input list of integers
public class ArrayCombination {

    public List<List<Integer>> combination(int[] input, int index) {
        if(index == input.length) {
            List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        List<List<Integer>> result = new LinkedList<>();
        for(List<Integer> combination: combination(input, index+1)) {
            //Exclude current item
            result.add(new LinkedList<Integer>(combination));
            //Include current item
            combination.add(0, input[index]);
            result.add(combination);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayCombination mainObject = new ArrayCombination();
        int[] input = {1,2,3};
        List<List<Integer>> result = mainObject.combination(input, 0);
        System.out.println(result);
    }
}
