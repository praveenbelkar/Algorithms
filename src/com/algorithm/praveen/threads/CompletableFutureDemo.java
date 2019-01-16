package com.algorithm.praveen.threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureDemo {

    public static class Task implements Supplier<Integer> {
        int value = 0;

        public Task(int value) {
            this.value = value;
        }

        @Override
        public Integer get() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return value;
        }
    }

    public void featureDemo() {
        Task task1 = new Task(5);
        Task task2 = new Task(10);

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(task1);
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(task2);
        System.out.println("here");
        CompletableFuture<Integer> completableFuture3 = completableFuture1.thenCombineAsync(completableFuture2, (result1, result2) -> {
            System.out.println("val1: " + result1);
            System.out.println("val2: " + result2);
            return result1 + result2;
        });
        System.out.println("here...2");
        completableFuture3.whenCompleteAsync( (result, exception) -> {
            System.out.println("result: " + result);
            //returnValue = result;
            //return;
        });
        completableFuture3.join();
    }

    public static void main(String[] args) {
        CompletableFutureDemo mainObject = new CompletableFutureDemo();
        //mainObject.featureDemo();
        test();
    }

    private static class Container {
        Integer key;
        Integer val;

        public Container(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    private static void test(){
        //List<Integer> input = Arrays.asList(2,2,3,1,3,2,1,2,2,3,1,1);
        //input.stream().map(element -> new Container(element, element)).collect(Collectors.groupingBy());
        int[] input = {2,2,3,1,3,2,1,2,2,3,1,1};
        int k = 3;
        Map<Integer, Container> countMap = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            Container container = null;
            Container val = countMap.get(input[i]);
            if(null == val || val.val == 0) {
                container = new Container(input[i], 1);
            } else {
                container = new Container(input[i], val.val+1);
            }
            countMap.put(input[i], container);
        }

        List<Container> sortedContainers = countMap.values().stream().sorted( (val1, val2) -> {
            return val2.getVal() - val1.getVal();
        }).collect(Collectors.toList());
        System.out.println(sortedContainers);
        System.out.println("result: " + sortedContainers.get(k-1).getKey());
    }
}
