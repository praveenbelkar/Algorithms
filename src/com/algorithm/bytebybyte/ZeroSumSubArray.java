package com.algorithm.bytebybyte;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.byte-by-byte.com/zerosum
 * Given an array, write a function to find any subarray that sums to zero, if one exists.
 eg.
 zeroSum({1, 2, -5, 1, 2, -1}) = [2, -5, 1, 2]
 */
public class ZeroSumSubArray {

    public int[] zeroSumSubArray(int[] input){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<input.length; i++){
            sum = sum + input[i];
            Integer position = map.get(sum);
            if(null != position || sum == 0 || input[i] == 0){
                return Arrays.copyOfRange(input, position+1, i+1);
            }else{
                map.put(sum, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ZeroSumSubArray mainObject = new ZeroSumSubArray();
        //int[] input = {1,2,-5,1,2,-1};
        //int[] input = {4,2,-3,1,6};
        int[] input = {4, 2, 0, 1, 6};

        int[] result = mainObject.zeroSumSubArray(input);
        if(null != result) {
            Arrays.stream(result).forEach(element -> System.out.print(element + " "));
        }
    }
}
