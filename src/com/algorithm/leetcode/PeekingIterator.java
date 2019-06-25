package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/peeking-iterator/
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 *
 * Example:
 *
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 */
public class PeekingIterator implements Iterator<Integer> {

    private Integer next = 0;
    private Integer peek = 0;
    private boolean hasNext = false;
    private Iterator<Integer> newIt = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        newIt = iterator;
        if(newIt.hasNext()) {
            peek = newIt.next();
            hasNext = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        next = peek;
        if(newIt.hasNext()) {
            peek = newIt.next();
            hasNext = true;
        } else {
            peek = null;
            hasNext = false;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1);
        PeekingIterator pit = new PeekingIterator(list.iterator());
        while(pit.hasNext()) {
            System.out.println("peek: " + pit.peek());
            System.out.println("next: " +pit.next());
            System.out.println("peek: " + pit.peek());

            System.out.println("------------------");
        }
    }
}