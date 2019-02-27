package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum.
 If there is a choice tie between answers, output all of them with no order requirement.
 You could assume there always exists an answer.

 Example 1:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".
 Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */
public class P599_MinIndexSumTwoList {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, List<Integer>> map = new HashMap<>();
        populateMapForList(list1, map);
        populateMapForList(list2, map);
        int leastIndex = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) {
                int sumIndex = entry.getValue().stream().reduce(0, (a,b) -> a+b);
                if(sumIndex <= leastIndex) {
                    leastIndex = sumIndex;
                }
            }
        }

        for(Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            if(entry.getValue().size() > 1) {
                int sumIndex = entry.getValue().stream().reduce(0, (a,b) -> a+b);
                if(sumIndex == leastIndex) {
                    result.add(entry.getKey());
                }
            }
        }

        String[] resultArray = new String[result.size()];
        for(int i=0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void populateMapForList(String[] list1, Map<String, List<Integer>> map) {
        for(int i=0; i < list1.length; i++) {
            List<Integer> indexList = map.get(list1[i]);
            if(null == indexList) {
                indexList = new ArrayList<>();
                indexList.add(i);
            } else {
                indexList.add(i);
            }
            map.put(list1[i], indexList);
        }
    }

    public static void main(String[] args) {
        P599_MinIndexSumTwoList mainObject = new P599_MinIndexSumTwoList();
/*
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] result = mainObject.findRestaurant(list1, list2);
        Arrays.stream(result).forEach(element -> System.out.print(element + " "));
*/

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result = mainObject.findRestaurant(list1, list2);
        Arrays.stream(result).forEach(element -> System.out.print(element + " "));


    }
}
