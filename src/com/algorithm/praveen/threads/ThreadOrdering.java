package com.algorithm.praveen.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadOrdering {

    private static class Flag {
        public volatile boolean flag;
    }

    volatile Flag[] flagArray = {new Flag(), new Flag(), new Flag(), new Flag(), new Flag(), new Flag(), new Flag(), new Flag(), new Flag()};
    volatile int flagPosition = 0;

    public class Task implements Runnable {
        private Object lock;
        private volatile Flag flag;
        private List<Integer> list;

        public Task(Object lock, Flag flag, List<Integer> list) {
            this.lock = lock;
            this.flag = flag;
            this.list = list;
        }

        @Override
        public void run() {
            for(int i = 0; i < list.size(); i++) {
                synchronized (lock) {
                    while(flag.flag == false) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(list.get(i) + " ");
                    if(list.get(i) == 9) {
                        System.out.println();
                    }
                    flag.flag = false;
                    activateNextFlag();
                    lock.notifyAll();
                }
            }
        }

        public void activateNextFlag() {
            synchronized (lock) {
                flagPosition = (flagPosition + 1) % flagArray.length;
                flagArray[flagPosition].flag = true;
            }
        }
    }

    public void orchestrate() {
        Object lock = new Object();

        flagArray[0].flag = true;
        Task task1 = new Task(lock, flagArray[0], Arrays.asList(1,1,1,1,1));
        Task task2 = new Task(lock, flagArray[1], Arrays.asList(2,2,2,2,2));
        Task task3 = new Task(lock, flagArray[2], Arrays.asList(3,3,3,3,3));
        Task task4 = new Task(lock, flagArray[3], Arrays.asList(4,4,4,4,4));
        Task task5 = new Task(lock, flagArray[4], Arrays.asList(5,5,5,5,5));
        Task task6 = new Task(lock, flagArray[5], Arrays.asList(6,6,6,6,6));
        Task task7 = new Task(lock, flagArray[6], Arrays.asList(7,7,7,7,7));
        Task task8 = new Task(lock, flagArray[7], Arrays.asList(8,8,8,8,8));
        Task task9 = new Task(lock, flagArray[8], Arrays.asList(9,9,9,9,9));


        ExecutorService executorService = Executors.newFixedThreadPool(9);
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.submit(task4);
        executorService.submit(task5);
        executorService.submit(task6);

        executorService.submit(task7);
        executorService.submit(task8);
        executorService.submit(task9);

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        ThreadOrdering mainObject = new ThreadOrdering();
        mainObject.orchestrate();
    }
}
