package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/count-primes/
 * Count the number of prime numbers less than a non-negative number, n.
 Example:
 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class P204_CountPrimes {

    public int countPrimes(int n) {
        if( n <= 2) {
            return 0;
        }

        int count = 0;
        for(int i=2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int number) {
        for(int i=2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        System.out.println(number);
        return true;
    }

    public static void main(String[] args) {
        P204_CountPrimes mainObject = new P204_CountPrimes();
        System.out.println(mainObject.countPrimes(13));
    }
}
