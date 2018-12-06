package com.algorithm.praveen.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitForNThreads {
    static boolean[] flagArray;

    static {
        WaitForNThreads.flagArray = new boolean[5];
        for (int i = 0; i < 5; i++) {
            WaitForNThreads.flagArray[i] = true;
        }
    }

    public static class Poller implements Runnable {
        Lock lock;

        public Poller(Lock lock1) {
            lock = lock1;
        }

        @Override
        public void run() {
            while (true) {
                lock.tryLock();
                if (allEntriesInFlagArrayFalse()) {
                    setAllEntriesInFlagArrayTrue();
                }
                lock.unlock();
            }
        }

        private void setAllEntriesInFlagArrayTrue() {
            for (int i = 0; i < flagArray.length; i++) {
                flagArray[i] = true;
            }
        }

        private boolean allEntriesInFlagArrayFalse() {
            for (int i = 0; i < flagArray.length; i++) {
                if (flagArray[i] == true) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Task implements Callable<Void> {

        CountDownLatch countDownLatch;

        Lock lock;
        int threadIndex = 0;

        public Task(CountDownLatch countDownLatch, int threadIndex, Lock lock1) {
            this.countDownLatch = countDownLatch;
            this.threadIndex = threadIndex;
            lock = lock1;
        }

        @Override
        public Void call() {
            /*rendezvous();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed rendezvous....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            critical(5, threadIndex);
            return null;
        }

        private void rendezvous() {
            System.out.println("Completed Rendezvous..." + Thread.currentThread().getName());
            countDownLatch.countDown();
        }

        private void critical(int n, int threadIndex) {
            System.out.println("Entering critical" + threadIndex + " "+Thread.currentThread().getName());
            if (n == 0) {
                return;
            }
            //lock.tryLock();
            while (flagArray[threadIndex] == false) {
                //lock.unlock();
            }
            lock.tryLock();
            if (flagArray[threadIndex] == true) {
                System.out.println("Completed critical..." + Thread.currentThread().getName());
                flagArray[threadIndex] = false;
            }
            lock.unlock();
            critical(n - 1, threadIndex);
        }
    }

    public void coordinateThreads(int n, Lock lock) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Task> taskList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            taskList.add(new WaitForNThreads.Task(countDownLatch, i, lock));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.invokeAll(taskList);
        Thread.sleep(10000);
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        WaitForNThreads.Poller poller = new WaitForNThreads.Poller(lock);
        Thread thread = new Thread(poller);
        thread.start();

        WaitForNThreads mainObject = new WaitForNThreads();
        mainObject.coordinateThreads(4, lock);
    }
}