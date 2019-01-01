package com.algorithm.praveen.arrays;

//Given an  element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . For example, Assume  and . The following table lists all subarrays and their moduli:
//For example, Assume  and a=[1,2,3] and m=2, output = 1

import java.util.Arrays;

public class MaxModuloSubArray {

    public long maxSum(long[] a, long m) {

        long result = Long.MIN_VALUE;
        for(int i=0; i < a.length; i++) {
            for(int j=0; j <= i; j++) {
                long sum = 0;
                for(int k=j; k <=i; k++) {
                    sum = sum + a[k];
                }
                if( (sum%m) > result) {
                    result = sum%m;
                }

            }
        }
        return result;
    }

    public long maxSumEfficient(long[] a, long m) {
        long[] temp = Arrays.copyOf(a, a.length);
        long sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            temp[i] = sum;
        }

        for(int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        long result = 0;
        for(int i = 1; i < a.length; i++) {
            long maxSofar = 0;
            for(int j=0; j <= i; j++) {
                maxSofar = (temp[i]-temp[j]) % m;

                if(result < maxSofar) {
                    result = maxSofar;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxModuloSubArray mainObject = new MaxModuloSubArray();
        long[] input = {3,3,2,2,5}; long m  =7;
        //long[] input = {1,5,9}; long m  = 5;
        System.out.println(mainObject.maxSum(input, m));
    }
}
