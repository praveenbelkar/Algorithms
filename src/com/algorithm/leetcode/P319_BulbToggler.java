package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bulb-switcher/
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Input: 3
 Output: 1
 Explanation:
 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 */
public class P319_BulbToggler {

    public int bulbSwitch1(int n) {
        if(n < 1) {
            return 0;
        }
        int[] input = new int[n];
        for(int i=0; i < n; i++) {
            input[i] = 1;
        }

        for(int i=1; i < n; i++) {
            for(int j=i; j < n; j=j+i+1){
                if(input[j] == 0) {
                    input[j] = 1;
                } else {
                    input[j] = 0;
                }
            }
            //Arrays.stream(input).forEach(element -> System.out.print(element + " "));
            //System.out.println();
        }

        int count = 0;
        for(int i=0; i < input.length; i++) {
            if(input[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public int bulbSwitch(int n) {
        if(n <= 1) {
            return n;
        }
        int number = (int)Math.pow(2,n) - 1;

        for(int i=2; i <= n; i++) {
            int toggleNumber = 0;
            int orNumber = (int) Math.pow(2, n-1);
            orNumber = orNumber >> (i-1);
            while(orNumber != 0) {
                toggleNumber = toggleNumber | orNumber;
                orNumber = orNumber >> i;
            }
            number = number ^ toggleNumber;
        }

        System.out.println(number);
        //Check set bits in number
        int count = 0;
        while(number != 0) {
            if( (number & 1) == 1 ) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        P319_BulbToggler mainObject = new P319_BulbToggler();
        //System.out.println(mainObject.bulbSwitch(99999999));
        System.out.println(mainObject.bulbSwitch(10));
    }
}
