package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fibonacci {
    public int fib(int N) {
        if(N < 0) {
            return 0;
        }
        int num1 = 0;
        int num2 = 1;
        if(N == 0) {
            return num1;
        }
        if(N == 1) {
            return num2;
        }
        int num3 = num1 + num2;
        int cnt = 1;
        while(cnt < N){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            cnt++;
        }
        return num3;
    }

    public static void main(String[] args) {
        Fibonacci mainObject = new Fibonacci();
        System.out.println(mainObject.fib(2));
        System.out.println(mainObject.fib(3));
        System.out.println(mainObject.fib(4));
    }
}
