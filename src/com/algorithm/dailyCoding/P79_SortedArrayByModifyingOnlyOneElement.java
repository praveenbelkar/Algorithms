package com.algorithm.dailyCoding;

public class P79_SortedArrayByModifyingOnlyOneElement {

    public boolean isSortedByModifyingAtmostOneElement(int[] input) {
        int firstElement = input[0];
        int secondElement = input[1];
        int modifiedCnt = 0;

        for(int i=1; i < input.length; i++) {
            firstElement = input[i-1];
            secondElement = input[i];
            if(firstElement > secondElement) {
                input[i-1] = secondElement-1;
                modifiedCnt++;
            }
            if(modifiedCnt > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P79_SortedArrayByModifyingOnlyOneElement mainObject = new P79_SortedArrayByModifyingOnlyOneElement();
        int[] input1 = {1,3,5,9,7,11,13};
        System.out.println(mainObject.isSortedByModifyingAtmostOneElement(input1));

        int[] input2 = {1,3,5,9,7,11,13, 12};
        System.out.println(mainObject.isSortedByModifyingAtmostOneElement(input2));

    }
}
