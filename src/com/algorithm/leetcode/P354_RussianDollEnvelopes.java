package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class P354_RussianDollEnvelopes {

    private static class Envelope {
        int start;
        int end;

        public Envelope(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        if(null == envelopes || envelopes.length == 0) {
            return 0;
        }
        int max = 1;

        int[] lis = new int[envelopes.length];
        Arrays.fill(lis, 1);

        List<Envelope> envelopeList = new ArrayList<>();
        for(int i=0; i < envelopes.length; i++) {
            envelopeList.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }

        envelopeList.sort((env1, env2) -> {
            if(env1.start == env2.start) {
                return env1.end - env2.end;
            }
            return env1.start - env2.start;
        });

        for(int i=1; i < envelopeList.size(); i++) {
            for(int j=0; j < i; j++) {
                if(envelopeList.get(i).start > envelopeList.get(j).start && envelopeList.get(i).end > envelopeList.get(j).end) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
                max = Math.max(max, lis[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        P354_RussianDollEnvelopes mainObject = new P354_RussianDollEnvelopes();
        int[][] input = new int[][]{
                {1,1}//{5,4}, {6,4}, {6,7}, {2,3}
        };

        System.out.println(mainObject.maxEnvelopes(input));
    }
}
