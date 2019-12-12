package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class P295_StreamMedian {

    static class MedianFinder {

        private List<Double> list = new ArrayList<Double>();
        private boolean isOdd = false;
        private int medianPosition = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if(list.size() == 0) {
                list.add(new Double(num));
                isOdd = !isOdd;
                return;
            }

            if(list.size() == 1) {
                if(list.get(0) > num) {
                    list.add(0, new Double(num));
                } else {
                    list.add(new Double(num));
                }
                isOdd = !isOdd;
                return;
            }
            int positionToBeInserted = getPositionToBeSorted(num, 0, list.size()-1);
            list.add(positionToBeInserted, new Double(num));
            isOdd = !isOdd;

            if(positionToBeInserted > medianPosition && isOdd) { //previously it is even sized
                medianPosition = medianPosition + 1;
            } else if(positionToBeInserted <= medianPosition && isOdd) { //previously it is odd sized
                    medianPosition = medianPosition + 1;
            }
        }

        private int getPositionToBeSorted(int num, int low, int high) {
            if(low <= high) {
                int mid = low + (high - low)/2;
                if(list.get(mid) == num || (mid >= 1 && (list.get(mid-1) < num && list.get(mid) > num))) {
                    return mid;
                } else if(mid == 0) {
                    if(num <= list.get(mid)) {
                        return 0;
                    } else {
                        return getPositionToBeSorted(num, mid+1, high);
                    }
                } else if(mid == list.size() - 1){
                    if(num >= list.get(mid)) {
                        return mid+1;
                    } else {
                        return getPositionToBeSorted(num, low, mid -1);
                    }
                } else if(list.get(mid) < num) {
                    return getPositionToBeSorted(num, mid+1, high);
                } else {
                    return getPositionToBeSorted(num, low, mid-1);
                }
            }
            return -1;
        }

        public double findMedian() {
            if(isOdd) {
                return list.get(medianPosition);
            } else {
                return (list.get(medianPosition) + list.get(medianPosition+1))/2;
            }
        }

        private void printList() {
            list.stream().forEach( ele -> System.out.print(ele + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        P295_StreamMedian.MedianFinder obj = new P295_StreamMedian.MedianFinder();
/*
        addNumber(obj, 30);
        addNumber(obj, 20);
        addNumber(obj, 40);
        addNumber(obj, 35);*/

        addNumber(obj, 1);
        addNumber(obj, 2);
        addNumber(obj, 3);
        addNumber(obj, 4);
        addNumber(obj, 5);

        /*addNumber(obj, 5);
        addNumber(obj, 4);
        addNumber(obj, 3);
        addNumber(obj, 2);
        addNumber(obj, 1);
*/
    }

    private static void addNumber(MedianFinder obj, int num) {
        obj.addNum(num);
        obj.printList();

        double param_2 = obj.findMedian();
        System.out.println("median: " + param_2);
    }
}
