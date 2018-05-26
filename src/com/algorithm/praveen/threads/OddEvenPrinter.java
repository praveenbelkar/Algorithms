package com.algorithm.praveen.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OddEvenPrinter {
    public  static boolean printOdd = true;

    public static class EvenPrinter implements Runnable {

        private Object lock;


        public EvenPrinter(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for(int i=0; i < 20; i=i+2) {
                synchronized (lock) {
                    lock.notify();
                    if(!OddEvenPrinter.printOdd){
                        System.out.println(i);
                        OddEvenPrinter.printOdd = !printOdd;
                    }
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class OddPrinter implements Runnable {

        private Object lock;

        public OddPrinter(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for(int i = 1; i < 20; i=i+2) {
                synchronized (lock) {
                    lock.notify();
                    if(OddEvenPrinter.printOdd) {
                        System.out.println(i);
                        OddEvenPrinter.printOdd = !OddEvenPrinter.printOdd;
                    }
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        EvenPrinter evenPrinter = new EvenPrinter(lock);
        OddPrinter oddPrinter = new OddPrinter(lock);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(evenPrinter);
        executorService.submit(oddPrinter);
    }
}
