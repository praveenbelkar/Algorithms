package com.algorithm.praveen.dynamicprogram;

import java.util.Arrays;

public class StairCaseNumberOfWaysToReachTop {

    private int numberOfWaysToReachTop(int totalNumberOfSteps, int maxAllowedJumpAtATime) {
        if(totalNumberOfSteps < 0) {
            return 0;
        }
        if(totalNumberOfSteps == 0) {
            return 1;
        }

        int totalNumberOfWaysToTop = 0;
        for(int i=1; i <= maxAllowedJumpAtATime; i++) {
            totalNumberOfWaysToTop += numberOfWaysToReachTop(totalNumberOfSteps - i, maxAllowedJumpAtATime);
        }
        return totalNumberOfWaysToTop;
    }

    private int numberOfWaysToReachTopDPTopDown(int totalNumberOfSteps, int maxAllowedJumpAtATime) {
        int[] cache = new int[totalNumberOfSteps+1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return numberOfWaysToReachTopDPTopDownUtil(totalNumberOfSteps, maxAllowedJumpAtATime, cache);
    }

    private int numberOfWaysToReachTopDPTopDownUtil(int totalNumberOfSteps, int maxAllowedJumpAtATime, int[] cache) {
        if(totalNumberOfSteps < 0){
            return 0;
        }
        if(totalNumberOfSteps >= 0 && cache[totalNumberOfSteps] != -1) {
            return cache[totalNumberOfSteps];
        }

        int totalNumberOfWaysToTop = 0;
        for(int i=1; i <= maxAllowedJumpAtATime; i++) {
            totalNumberOfWaysToTop += numberOfWaysToReachTopDPTopDownUtil(totalNumberOfSteps - i, maxAllowedJumpAtATime, cache);
        }
        return totalNumberOfWaysToTop;
    }

    private int numberOfWaysToReachTopDPBottomUp(int totalNumberOfSteps, int maxAllowedJumpAtATime) {
        int[] cache = new int[totalNumberOfSteps + 1];
        Arrays.fill(cache , 0);
        cache[0] = 1;
        cache[1] = 1;

        int totalNumberOfWaysToTop = 0;
        for(int i = 2; i <= totalNumberOfSteps; i++) {
            for(int allowedStep = 1; allowedStep <= maxAllowedJumpAtATime; allowedStep++) {
                if(i-allowedStep >= 0){
                    cache[i] += cache[i-allowedStep];
                }
            }
        }
        return cache[totalNumberOfSteps];
    }

    public static void main(String[] args) {
        int totalNumberOfSteps = 4;
        int maxAllowedJumpAtATime = 3;
        StairCaseNumberOfWaysToReachTop mainObject = new StairCaseNumberOfWaysToReachTop();
        System.out.println(mainObject.numberOfWaysToReachTop(totalNumberOfSteps, maxAllowedJumpAtATime));
        System.out.println(mainObject.numberOfWaysToReachTopDPTopDown(totalNumberOfSteps, maxAllowedJumpAtATime));
        System.out.println(mainObject.numberOfWaysToReachTopDPBottomUp(totalNumberOfSteps, maxAllowedJumpAtATime));
    }



}
