package com.algorithm.nsw.education;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {

        if(null == A || A.length == 0) {
            return 0;
        }

        if(A.length == 1) {
            return 0;
        }

        int curDiff = 0;
        int prevDiff = A[1] - A[0];
        int windowSize = 1;

        int prevNumber = A[0];
        int curNumber = 0;
        int result = 0;
        boolean firstIteration = true;
        int resultLimit = 1_000_000_000;

        for(int i=1; i < A.length; i++) {
            curNumber = A[i];
            curDiff = curNumber - prevNumber;
            if(curDiff != prevDiff ) {

                if(windowSize >= 3) {
                    result = result + getPossibleValidWindows(windowSize);
                    if(result > resultLimit) {
                        return -1;
                    }
                }
                windowSize = 2;
            } else {
                windowSize++;
            }
            prevDiff = curDiff;
            prevNumber = curNumber;
        }

        if(windowSize >= 3) {
            result = result + getPossibleValidWindows(windowSize);
            if(result > resultLimit) {
                return -1;
            }
        }
        return result;
    }

    private int getPossibleValidWindows(int windowSize) {
        return (windowSize-2)*(windowSize-1)/2;
    }

    public static void main(String[] args) {
        int[] A =  {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        Solution mainObject = new Solution();

        int[] B = new int[10000];
        Arrays.fill(B, 2);
        System.out.println(mainObject.solution(B));
    }
}
