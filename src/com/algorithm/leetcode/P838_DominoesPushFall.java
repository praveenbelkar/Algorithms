package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/push-dominoes/
 *
 * There are N dominoes in a line, and we place each domino vertically upright.
 *
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 *
 *
 *
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 *
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 *
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 *
 * Return a string representing the final state.
 *
 * Example 1:
 *
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * Example 2:
 *
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 */
public class P838_DominoesPushFall {

    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.trim().length() == 0) {
            return null;
        }

        int[] nearestRonLeftSide = new int[dominoes.length()];
        int[] nearestLonRightSide = new int[dominoes.length()];

        Arrays.fill(nearestLonRightSide, -1);
        Arrays.fill(nearestRonLeftSide, -1);

        int indexOfNearestR = -1;
        int indexOfNearestL = -1;

        for(int i=0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) == 'R') {
                indexOfNearestR = i;
                //nearestRonLeftSide[i] = i;
                continue;
            }
            if(dominoes.charAt(i) == '.') {
                nearestRonLeftSide[i] = indexOfNearestR;
            }
        }

        for(int i = dominoes.length() - 1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') {
                indexOfNearestL = i;
                //nearestLonRightSide[i] = i;
                continue;
            }
            if(dominoes.charAt(i) == '.') {
                nearestLonRightSide[i] = indexOfNearestL;
            }
        }

        System.out.println("nearest L on Right side");
        for(Integer element: nearestLonRightSide) {
            System.out.print(element + " ");
        }

        System.out.println("\nnearest R on left side");
        for(Integer element: nearestRonLeftSide) {
            System.out.print(element + " ");
        }
        System.out.println();
        char[] dominoesChar = dominoes.toCharArray();
        for(int i=0; i < dominoesChar.length; i++) {
            if(dominoesChar[i] == '.') {
                if(nearestLonRightSide[i] == -1 && nearestRonLeftSide[i] != -1) {
                    dominoesChar[i] = 'R';
                    continue;
                }
                if(nearestLonRightSide[i] != -1 && nearestRonLeftSide[i] == -1) {
                    dominoesChar[i] = 'L';
                    continue;
                }
                if(Math.abs(i-nearestLonRightSide[i]) > Math.abs(i-nearestRonLeftSide[i])) {
                    dominoesChar[i] = 'R';
                } else if(Math.abs(i-nearestLonRightSide[i]) < Math.abs(i-nearestRonLeftSide[i])) {
                    dominoesChar[i] = 'L';
                }
            }
        }

        return new String(dominoesChar);
    }

    public static void main(String[] args) {
        P838_DominoesPushFall mainObject = new P838_DominoesPushFall();
        String input = ".L.R...LR..L..";
        System.out.println(input);
        System.out.println(mainObject.pushDominoes(input));
    }
}
