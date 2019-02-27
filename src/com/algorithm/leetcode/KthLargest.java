package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 which contains initial elements from the stream. For each call to the method KthLargest.add,
 return the element representing the kth largest element in the stream.

 Example:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 */
public class KthLargest {

    public static class Heap {
        int heapSize = 0;
        int[] heapArray = null;
        int currentSize = 0;

        public Heap(int heapSize) {
            this.heapSize = heapSize;
            heapArray = new int[heapSize];
            Arrays.fill(heapArray, Integer.MAX_VALUE);
        }

        public void minHeapify(int element) {
            heapArray[0] = element;
            int index = 0;
            Integer leftChild = null;
            Integer rightChild = null;
            Integer leftIndex = null;
            Integer rightIndex = null;

            while(notOrdered(index)) {
                if(inRange(2*index + 1)) {
                    leftIndex = 2*index + 1;
                    leftChild = heapArray[leftIndex];
                }
                if(inRange(2*index + 2)) {
                    rightIndex = 2*index + 2;
                    rightChild = heapArray[rightIndex];
                }
                int swapIndex = getSwapPosition(index, leftIndex, rightIndex);
                swap(heapArray, index, swapIndex);
                index = swapIndex;
            }
        }

        private void swap(int[] heapArray, int pos1, int pos2) {
            int temp = heapArray[pos1];
            heapArray[pos1] = heapArray[pos2];
            heapArray[pos2] = temp;
        }

        private int getSwapPosition(int index, Integer leftIndex, Integer rightIndex) {
            Integer left = Integer.MAX_VALUE;
            Integer right = Integer.MAX_VALUE;
            if(inRange(leftIndex)) {
                left = heapArray[leftIndex];
            }
            if(inRange(rightIndex)) {
                right = heapArray[rightIndex];
            }
            return Math.min(left, right);
        }

        private boolean inRange(int i) {
            return i >=0 && i <= heapArray.length-1;
        }

        private boolean notOrdered(int index) {
            Integer leftChild = null;
            Integer rightChild = null;
            Integer leftIndex = null;
            Integer rightIndex = null;
            boolean leftOrder = true;
            boolean rightOrder = true;

            if(inRange(2*index + 1) && heapArray[2*index+1] != Integer.MAX_VALUE) {
                leftIndex = 2*index + 1;
                leftChild = heapArray[leftIndex];
                leftOrder = heapArray[index] < leftChild;
            }
            if(inRange(2*index + 2) && heapArray[2*index+2] != Integer.MAX_VALUE) {
                rightIndex = 2*index + 2;
                rightChild = heapArray[rightIndex];
                rightOrder = heapArray[index] < rightChild;
            }
            return leftOrder && rightOrder;
        }

        private int parent(int index) {
            return (index-1)/2;
        }

        private int add(int val) {
            if(currentSize >= heapSize) {
                if(heapArray[0] < val) {
                    minHeapify(val);
                }

            } else {
                minHeapify(val);
                currentSize++;
            }
            return heapArray[0];
        }
    }

    private Heap heap = null;
    public KthLargest(int k, int[] nums) {
        heap = new Heap(k);
        for(int i=0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
    }

    public int add(int val) {
        return heap.add(val);
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(3);
        System.out.println(param_1);
        int param_2 = obj.add(5);
        System.out.println(param_2);

        int param_3 = obj.add(10);
        System.out.println(param_3);

        int param_4 = obj.add(9);
        System.out.println(param_4);

        int param_5 = obj.add(4);
        System.out.println(param_5);

    }
}
