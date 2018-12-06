package com.algorithm.praveen.threads;

public class CustomJoin {

    public static class MyThread extends  Thread {

        private volatile boolean isCompleted = false;

        public void run() {
            System.out.println("MyThread ... run..."+Thread.currentThread().getName());
            beforeCompletion();
        }

        private synchronized void beforeCompletion() {
            isCompleted = true;
            notify();
        }

        public synchronized void myJoin(){
            System.out.println("inside myJoin..."+Thread.currentThread().getName());
            while (isCompleted == false) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void callingFunction() {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Before calling myJoin.."+Thread.currentThread().getName());
        myThread.myJoin();
        System.out.println("myJoin is called.. "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CustomJoin mainObject = new CustomJoin();
        mainObject.callingFunction();
    }
}
