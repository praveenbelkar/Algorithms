package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int position = 0;
        while(low <= high) {
            position = findPivot(nums, low, high);
            if(position+1 == k){
                return nums[position];
            } else if(position < k) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }
        return nums[position];
    }

    private int findPivot(int[] nums, int low, int high) {
        int pivotIndex = low;
        int pivot = nums[pivotIndex];
        low = low + 1;
        while(low <= high) {
            while(low <= high && nums[low] >= pivot) {
                low++;
            }
            while (high >= low && nums[high] < pivot) {
                high--;
            }

            if(low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            } else {
                break;
            }
        }
        swap(nums, high, pivotIndex);
        return high;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement mainObject = new KthLargestElement();
        int[] input = {6,2,1,5,3,4};
        int k = 2;
        /*int[] input = {3,2,3,1,2,4,5,5,6};
        int k = 4;*/
        /*int[] input = {1};
        int k = 1;*/
        /*int[] input = {3,2,1,5,6,4};
        int k = 2;*/

        System.out.println(mainObject.findKthLargest(input, k));
    }
}
