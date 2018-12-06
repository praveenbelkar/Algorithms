package com.algorithm.praveen.dynamicprogram;

public class OptimalStrategy {

    public int strategise(int[] input, int start, int end, int sum) {
        if(start == end-1) {
            return sum + Math.max(input[start], input[end]);
        }

        return Math.max(strategise(input, start+1, end, sum),
                        strategise(input, start, end-1, sum));
    }

    public static void main(String[] args) {
        OptimalStrategy mainObject = new OptimalStrategy();
        int[] input = {5,3,7,10};
        System.out.println(mainObject.strategise(input, 0, input.length-1, 0));
    }
}
