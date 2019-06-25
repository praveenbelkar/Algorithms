package com.algorithm.macquaire;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinSum {

    public static int minSum(List<Integer> num, int k) {
        // Write your code here
        if(num == null || num.size() == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxPq = new PriorityQueue<>( (x,y) -> y-x );
        for(Integer element: num) {
            maxPq.add(element);
        }

        for(int i=0; i < k; i++) {
            int maxElement = maxPq.remove();
            int newElement = 0;
            if(maxElement%2 == 1) {
                newElement = (maxElement+1)/2;
            } else {
                newElement = maxElement/2;
            }
            maxPq.add(newElement);
        }

        int result = 0;
        for(int i=0; i < num.size(); i++) {
            result = result + maxPq.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minSum(Arrays.asList(10,20,7), 4));
    }
}
