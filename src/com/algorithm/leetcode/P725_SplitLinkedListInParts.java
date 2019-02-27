package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 Return a List of ListNode's representing the linked list parts that are formed.

 Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 Example 1:
 Input:
 root = [1, 2, 3], k = 5
 Output: [[1],[2],[3],[],[]]

 Input:
 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 */
public class P725_SplitLinkedListInParts {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null) {
            return null;
        }
        int numberOfElementsInEachList = 0;
        int extraElement = 0;
        int sizeOfList = getSizeOfList(root);
        if(k > sizeOfList) {
            numberOfElementsInEachList = 1;
            extraElement = sizeOfList % k;
        } else {
            numberOfElementsInEachList = sizeOfList/k;
            extraElement = sizeOfList % k;
        }


        ListNode[] result = new ListNode[numberOfElementsInEachList];
        ListNode temp = root;
        for(int i=0, j = extraElement; i < k; i++, j--) {
            result[i] = new ListNode(temp.val);
            ListNode prev = result[i];
            int cnt = 1;
            int maxElement = (j > 0 ? numberOfElementsInEachList +1 : numberOfElementsInEachList);
            while(cnt < maxElement && temp != null) {
                temp = temp.next;
                prev.next = new ListNode(temp.val);
                prev = prev.next;
                cnt++;
            }
            if(prev != null) {
                prev = null;
            }
            if(temp != null) {
                temp = temp.next;
            }

        }
        return result;
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

    private static void printList(ListNode node) {
        ListNode temp = node;
        while(temp != null) {
            System.out.print(temp.val + " ->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static void printResult(ListNode[] result) {
        for(ListNode listNode: result) {
            printList(listNode);
        }
    }

    public static void main(String[] args) {
        P725_SplitLinkedListInParts mainObject = new P725_SplitLinkedListInParts();

/*
        ListNode head = mainObject.createList(new int[]{1,2,3,4,5,6,7,8,9,10});
        printList(head);
        System.out.println("-------------------");
        ListNode[] newHead = mainObject.splitListToParts(head, 3);
        printResult(newHead);
*/

        ListNode head = mainObject.createList(new int[]{1,2,3});
        printList(head);
        System.out.println("-------------------");
        ListNode[] newHead = mainObject.splitListToParts(head, 5);
        printResult(newHead);

    }

}

