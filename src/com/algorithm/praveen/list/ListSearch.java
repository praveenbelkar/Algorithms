package com.algorithm.praveen.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSearch {

    public static int degreeOfArray(List<Integer> arr) {
        Integer[] arrayInput = arr.toArray(new Integer[arr.size()]);
        int maxDegree = highestDegree(arrayInput,0,arrayInput.length-1);

        int currentDegree = 0;
        int leastSize = Integer.MAX_VALUE;
        int currentSize = 0;
        for(int i = 0; i < arrayInput.length - 1; i++) {

            for(int j = i+1; j < arrayInput.length; j++) {

                currentDegree = highestDegree(arrayInput, i, j);
                if(currentDegree == maxDegree) {

                    currentSize = j - i + 1;
                    if(leastSize > currentSize) {
                        leastSize = currentSize;
                    }
                }
            }
        }
        return leastSize;
    }

    public static Integer highestDegree(Integer[] elements, int start, int end) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer currentCount = 0;
        Integer maxDegree = 0;
        Integer currentValue = 0;
        for(int i = start; i <= end; i++) {
            Integer element = elements[i];
            currentCount = map.get(element);
            if(currentCount == null) {
                currentValue = 1;
            } else {
                currentValue = currentCount+1;
            }
            map.put(element, currentValue);
            if(maxDegree < currentValue) {
                maxDegree = currentValue;
            }
        }
        return maxDegree;
    }


    /*public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,1,3,2);
        //List<Integer> input = Arrays.asList(5,1,2,2,3,1);
        ListSearch mainObject = new ListSearch();
        System.out.println(degreeOfArray(input));
    }*/

    public static String rollTheString(String s, List<Integer> roll) {
        StringBuilder sb = new StringBuilder();

        for(Integer element: roll) {
                sb = new StringBuilder();
                sb.append(increment(s.substring(0,element)));
                sb.append(s.substring(element));
                s = sb.toString();
        }

        System.out.println(s);
        return s;
    }

    public static String increment(String input) {
        char[] charA = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        char temp = 0;
        for(int i = 0; i < charA.length; i++) {
            temp = increment(charA[i]);
            sb.append(temp);
        }
        System.out.println("increment: input: "+input+ " output: "+sb.toString());
        return sb.toString();
    }

    public static char increment(char ch) {
        if(ch == 'z')
            return 'a';
        if(ch == 'Z')
            return 'A';
        return (char)(ch+1);
    }

    public static void main(String[] args) {
        System.out.println(rollTheString("abz", Arrays.asList(3,2,1)));
    }

}
