package com.algorithm.bytebybyte;

/**
 * Find the median of two sorted equal length arrays.
 *
 * arr1 = [1, 3, 5]
 arr2 = [2, 4, 6]
 median(arr1, arr2) = 3.5
 */
public class MediianTwoSortedEqualLengthArray {
    public Double median(double[] arr1, double[] arr2, int start1, int end1, int start2, int end2) {
        //Base condition, if array is of length = 2
        if(end1 - start1 == 1) {
            double temp1 = Math.max(arr1[start1], arr2[start2]);
            double temp2 = Math.min(arr1[end1], arr2[end2]);
            return (temp1+temp2)/2;
        }

        int mid1 = start1 + (end1 - start1)/2;
        int mid2 = start2 + (end2 - start2)/2;
        double median1 = arr1[mid1];
        double median2 = arr2[mid2];

        if(median1 == median2){
            return median1;
        }

        if(median1 < median2) {
            return median(arr1, arr2, mid1, end1, start2, mid2);
        }else{
            return median(arr1, arr2, start1, mid1, mid2, end2);
        }
    }

    public static void main(String[] args) {
        MediianTwoSortedEqualLengthArray mainObject = new MediianTwoSortedEqualLengthArray();
        double[] input1 = {1,3,5};
        double[] input2= {2,4,6};
        System.out.println(mainObject.median(input1, input2, 0, input1.length-1, 0, input2.length-1));
    }
}
