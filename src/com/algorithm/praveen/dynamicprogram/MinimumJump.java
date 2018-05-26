package com.algorithm.praveen.dynamicprogram;

import java.util.Arrays;

public class MinimumJump {

    public void minimumJump(int[] array) {
        int[] minimumJump = new int[array.length+1];
        int[] path = new int[array.length];

        minimumJump[0] = 0;
        for(int i=1; i<minimumJump.length; i++) {
            minimumJump[i] = -1;//Integer.MAX_VALUE;
        }

        int temp = 0;
        for (int i=1; i <= array.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = i-array[j];
                //if(temp <= 0 ) {
                if( i <= j+array[j] ) {
                    if(minimumJump[i] <= 0) {
                        minimumJump[i] = minimumJump[j] + 1;
                    }
                    minimumJump[i] = Math.min(minimumJump[i], minimumJump[j] + 1);
                    //minimumJump[i] = getMinimum(minimumJump[i], minimumJump[j] + 1);
                }
            }
        }

        System.out.println(minimumJump[array.length]);
        Arrays.stream(minimumJump).forEach(System.out::println);
    }

    int getMinimum(int a, int b){
        if(a >=0 && b >=0) {
            return Math.min(a,b);
        }
        return a >=0 ? a: b;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,6,3,2,3,6,8,9,5};//{1,3,6,1,0,9};//{1,3,5,8,9,2,6,7,6,8,9};

        MinimumJump mainObject = new MinimumJump();
        mainObject.minimumJump(input);
        //System.out.println(mainObject.getMinimum(3,2));
    }
}
