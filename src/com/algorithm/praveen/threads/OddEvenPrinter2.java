package com.algorithm.praveen.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter2 {

    private static volatile boolean isOdd = false;

    public static class OddPrinterTask implements Runnable {

        private Lock lock;
        private Condition oddCondition;
        private Condition evenCondition;


        public OddPrinterTask(Lock lock, Condition oddCondition, Condition evenCondition) {
            this.lock = lock;
            this.oddCondition = oddCondition;
            this.evenCondition = evenCondition;
        }

        @Override
        public void run() {
            for(int i=0; i < 20; i++) {
                synchronized (lock) {
                    while(!OddEvenPrinter2.isOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Process
                    if(i % 2 == 1)
                        System.out.println(i);
                    isOdd = false;
                    lock.notify();
                }
            }

            System.out.println("Finished odd task");
        }

    }

    public static class EvenPrinterTask implements Runnable {

        private Lock lock;
        private Condition oddCondition;
        private Condition evenCondition;

        public EvenPrinterTask(Lock lock, Condition oddCondition, Condition evenCondition) {
            this.lock = lock;
            this.oddCondition = oddCondition;
            this.evenCondition = evenCondition;
        }

        @Override
        public void run() {
            for(int i=0; i < 20; i++) {
                synchronized (lock) {
                    while(isOdd) {
                        try {
                            evenCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Process
                    if(i % 2 == 0)
                        System.out.println(i);
                    isOdd = true;
                    oddCondition.signal();
                }
            }
            System.out.println("Finished even task");
        }
    }

    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock();
        executorService.submit(new OddPrinterTask(lock));
        executorService.submit(new EvenPrinterTask(lock));
        executorService.shutdown();
   */ }
}
