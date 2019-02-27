package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class P160_IntersectionLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int sizeA = getSizeOfList(headA);
        int sizeB = getSizeOfList(headB);
        int positionsToSkip = Math.max(sizeA, sizeB) - Math.min(sizeA, sizeB);
        ListNode biggerList = sizeA > sizeB ? headA:headB;
        ListNode smallerList = biggerList == headA ? headB : headA;
        int cnt = 0;
        while(cnt < positionsToSkip) {
            biggerList = biggerList.next;
            cnt++;
        }
        while(biggerList != null) {
            if(biggerList.val == smallerList.val) {
                return biggerList;
            }
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }
        return null;
    }

    private int getSizeOfList(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    private ListNode createList(int[] array) {
        ListNode prev = new ListNode(array[0]);
        ListNode head = prev;
        for(int i=1; i <= array.length-1; i++) {
            ListNode node = new ListNode(array[i]);
            prev.next = node;
            prev = node;
        }
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        P160_IntersectionLinkedList mainObject = new P160_IntersectionLinkedList();
        ListNode headA = mainObject.createList(new int[]{0,9,1,2,4});
        ListNode headB = mainObject.createList(new int[]{3,2,4});
        ListNode intersection = mainObject.getIntersectionNode(headA, headB);
        System.out.println(intersection.val);
    }

}
