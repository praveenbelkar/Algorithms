package com.algorithm.praveen.arrays;

import java.util.Arrays;
import java.util.IdentityHashMap;

//Rotate an array by k positions
public class RotateArray {

    public void rotateArray(Integer[] array, int numberOfPositions) {
        int previousIndexValue = 0;
        int currentIndexValue = 0;

        for(int k=0; k < numberOfPositions; k++) {
            for(int i=array.length-1; i >= 0; i--) {
                currentIndexValue = array[i];
                array[i] = previousIndexValue;
                previousIndexValue = currentIndexValue;
            }
            array[array.length-1] = previousIndexValue;
            printArray(array);
        }
    }

    public static<T> void printArray(T[] array) {
        for(int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,5};
        RotateArray mainObject = new RotateArray();
        System.out.println("Before:");
        printArray(input);
        System.out.println("-----------");
        mainObject.rotateArray(input, 5);
        //Arrays.stream(input).forEach(System.out::println);
        System.out.println("After:");
        printArray(input);
        System.out.println("-------");
        mainObject.testIdentityHashMap();
    }

    public void testIdentityHashMap() {
        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>(3);
        identityHashMap.put("a", 1);
        identityHashMap.put("b", 2);
        identityHashMap.put("3", 3);
        identityHashMap.put("4", 4);
        System.out.println(identityHashMap.size());
        identityHashMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
