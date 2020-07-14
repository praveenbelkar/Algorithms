package com.algorithm.leetcode;

import java.util.PriorityQueue;

public class P786_KthSmallestPrimeFraction {

    /*public static class Entry {
        int p;
        int q;
        Double val;
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>((entry1, entry2) -> {
            return (entry1.val - entry2.val) > 0 ? 1: 0;
        });
        for(int i=0; i < A.length-1; i++) {
            for(int j=i+1; j < A.length; j++) {
                Entry entry = new Entry();
                entry.p = String.valueOf(A[i]);
                entry.q = String.valueOf(A[j]);
                entry.val = Double.parseDouble(entry.p)/Double.parseDouble(entry.q);
                priorityQueue.add(entry);
            }
        }

        int cnt=1;
        while(cnt < K) {
            priorityQueue.poll();
        }
        Entry entry = priorityQueue.poll();
        int[] result = new int[2];
        result[0] = entry.p;
        result[1] = entry.q;
        return result[0][0];
    }*/

}
