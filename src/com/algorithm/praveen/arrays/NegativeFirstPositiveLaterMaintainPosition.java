package com.algorithm.praveen.arrays;

public class NegativeFirstPositiveLaterMaintainPosition {

    public void shuffleWithNegativesFirstPositivesLaterWithSpaceOn(int[] array) {
        int[] resultArray = new int[array.length];
        int index1 = 0 ;
        int index2 = array.length - 1;
        for(int negativeIndex = 0; negativeIndex < array.length; negativeIndex++ ) {
            if(array[negativeIndex] <= 0) {
                resultArray[index1] = array[negativeIndex];
                index1++;
            }
        }

        for( int positiveIndex = array.length-1; positiveIndex >= 0 ; positiveIndex--) {
            if(array[positiveIndex] > 0) {
                resultArray[index2] = array[positiveIndex];
                index2--;
            }
        }

        for(int i=0; i<resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] input = {4,-5,-15,-2,3,2,-10,1,5,-2};

        NegativeFirstPositiveLaterMaintainPosition mainObject = new NegativeFirstPositiveLaterMaintainPosition();
        mainObject.shuffleWithNegativesFirstPositivesLaterWithSpaceOn(input);
        mainObject.shuffleWithNegativesFirstPositivesLaterWithNoExtraSpace(input);
    }

    public  void shuffleWithNegativesFirstPositivesLaterWithNoExtraSpace(int[] array) {
        int startPositionOfPosition = -1;
        int lastNegativePosition = -1;
        for(int i = 0 ; i < array.length; i++) {
            if(array[i] <= 0) {
                lastNegativePosition++;
                int temp = array[i];
                shiftArray(array, lastNegativePosition+1, i);
                array[lastNegativePosition] = temp;
            }
        }

        System.out.println();
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private void shiftArray(int[] array, int startPosition, int endPosition) {
        for(int i=endPosition; i >= startPosition; i--) {
            array[i] = array[i-1];
        }
    }

}
