package com.algorithm.atlassian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    int find(List<Integer> headA, List<Integer> headB) {
        if(headA == null || headB == null) {
            return -1;
        }
        int sizeA = headA.size();
        int sizeB = headB.size();
        int positionsToSkip = Math.max(sizeA, sizeB) - Math.min(sizeA, sizeB);
        List biggerList = sizeA > sizeB ? headA:headB;
        List smallerList = biggerList == headA ? headB : headA;
        /*int cnt = 0;
        while(cnt < positionsToSkip) {
            biggerList.next;
            cnt++;
        }*/
        int cnt = positionsToSkip;
        int k = 0;
        while(cnt < biggerList.size()) {
            if(biggerList.get(cnt) != smallerList.get(k)) {
                return -1;
            }
            k++;
            cnt++;
        }

        return positionsToSkip;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        List<Integer> headA = new ArrayList<>();
        for(int i=0; i<size1; i++) {
            headA.add(sc.nextInt());
        }

        //System.out.println("---------------------");
        int size2 = sc.nextInt();
        List<Integer> headB = new ArrayList<>();
        for(int i=0; i<size2; i++) {
            headB.add(sc.nextInt());
        }
        //System.out.println("---------------------");

        //headA.stream().forEach(e -> System.out.print(e + " "));
        //System.out.println();
        //headB.stream().forEach(e -> System.out.print(e + " "));

        Solution mainObject = new Solution();
        System.out.println(mainObject.find(headA, headB));
    }
}
