package com.algorithm.praveen.recursion;

/*Write a recursive function that prints out the odd indices of an integer array.
        eg.
        printOdd({2,4,6,8,10,12})
        4
        8
        12
*/

public class PrintOddIndexNumber {

    public void printOddIndexNumbers(int[] input, int index) {
        if(index >= input.length) {
            return;
        }
        if(index % 2 == 1) {
            System.out.println(input[index]);
        }
        printOddIndexNumbers(input, index+1);
    }

    public static void main(String[] args) {
        PrintOddIndexNumber mainObject = new PrintOddIndexNumber();
        int[] input = {2,4,6,8,10,12};
        mainObject.printOddIndexNumbers(input, 0);
    }
}
