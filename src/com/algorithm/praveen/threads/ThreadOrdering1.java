package com.algorithm.praveen.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadOrdering1 {

    private volatile Integer flagId = 0;

    public class Task implements Runnable {
        private Object lock;
        private List<Integer> list;
        private volatile Integer threadId;

        public Task(Object lock, Integer threadId, List<Integer> list) {
            this.lock = lock;
            this.threadId = threadId;
            this.list = list;
        }

        @Override
        public void run() {
            for(int i = 0; i < list.size(); i++) {
                //System.out.println(i + " " + Thread.currentThread().getName());
                synchronized (lock) {

                    while(threadId != flagId) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(list.get(i));
                    activateNextFlag();
                    lock.notifyAll();
                }
            }
        }

        public void activateNextFlag() {
            synchronized (lock) {
                flagId = (flagId+1) % 3;
            }
        }
    }

    public void orchestrate() {
        Object lock = new Object();
        flagId = 0;
        Task task1 = new Task(lock, 0, Arrays.asList(1,1,1,1,1));
        Task task2 = new Task(lock, 1, Arrays.asList(2,2,2,2,2));
        Task task3 = new Task(lock, 2, Arrays.asList(3,3,3,3,3));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        ThreadOrdering1 mainObject = new ThreadOrdering1();
        mainObject.orchestrate();
    }
}
