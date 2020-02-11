package com.algorithm.leetcode.concurrency;

import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 * Suppose you are given the following code:
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // constructor
 *   public void zero(printNumber) { ... }  // only output 0's
 *   public void even(printNumber) { ... }  // only output even numbers
 *   public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 *
 * Input: n = 5
 * Output: "0102030405"
 */
public class P116_PrintZeroEvenOdd {

    private int n;
    private Object lock = new Object();
    private String flag = "zero";
    private boolean odd = true;
    private int index = 0;

    public P116_PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized(lock) {
            while(index <= n) {
                while(!flag.equals("zero")) {
                    lock.wait();
                }
                printNumber.accept(0);
                flag = odd ? "odd" : "even";
                odd = !odd;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized(lock) {
            while(index <= n) {
                while(!flag.equals("even")) {
                    lock.wait();
                }
                printNumber.accept(index);
                index++;
                flag = "zero";
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized(lock) {
            while(index <= n) {
                while(!flag.equals("odd")) {
                    lock.wait();
                }
                printNumber.accept(index);
                index++;
                flag = "zero";
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        P116_PrintZeroEvenOdd mainObject = new P116_PrintZeroEvenOdd(3);
        Thread thread1 = new Thread(()->{
            try {
                mainObject.zero(x-> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                mainObject.odd(x-> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try {
                mainObject.even(x-> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
