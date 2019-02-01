package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
public class MinCostClimbingStores {

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        int[] table = new int[cost.length+1];
        table[0] = 0;
        table[1] = 0;
        for(int i=2; i <= cost.length; i++) {
            table[i] = Math.min(table[i-1] + cost[i-1],
                    table[i-2] + cost[i-2]);
        }
        return table[cost.length];
    }

    public int minCostClimbingStairsRecursive(int[] cost) {
        return minCostClimbingStairsUtil(cost.length, cost);
    }

    private int minCostClimbingStairsUtil(int index, int[] cost) {
        if(index <= 1) {
            return 0;
        }

        return Math.min(
                minCostClimbingStairsUtil(index - 1, cost) + cost[index-1],
                minCostClimbingStairsUtil(index - 2, cost) + cost[index-2]
        );
    }

    public static void main(String[] args) {
        MinCostClimbingStores mainObject = new MinCostClimbingStores();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //int[] cost = {10, 15, 20};
        //int[] cost = {0,0,0};
        System.out.println(mainObject.minCostClimbingStairs(cost));
    }

}
