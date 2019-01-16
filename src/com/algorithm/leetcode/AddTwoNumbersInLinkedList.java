package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/add-two-numbers/submissions/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbersInLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null & l2 != null) {
            return l2;
        }
        if( l2 == null & l1 != null) {
            return l1;
        }

        int carry = 0;
        int remainder = 0;
        ListNode resultNodeHead = null;
        ListNode sumNode = null;
        ListNode currentNode = null;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if(sum >= 10){
                carry = sum / 10;
                remainder = sum % 10;
                sumNode = new ListNode(remainder);
            }else {
                carry = 0;
                sumNode = new ListNode(sum);
            }

            if(resultNodeHead == null) { //For the first node
                resultNodeHead = sumNode;
                currentNode = sumNode;
            } else {
                currentNode.next = sumNode;
                currentNode = sumNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + carry;
            if(sum >= 10){
                carry = sum / 10;
                remainder = sum % 10;
                sumNode = new ListNode(remainder);
            }else {
                carry = 0;
                sumNode = new ListNode(sum);
            }
            currentNode.next = sumNode;
            currentNode = sumNode;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + carry;
            if(sum >= 10){
                carry = sum / 10;
                remainder = sum % 10;
                sumNode = new ListNode(remainder);
            }else {
                carry = 0;
                sumNode = new ListNode(sum);
            }
            currentNode.next = sumNode;
            currentNode = sumNode;
            l2 = l2.next;
        }

        if(carry > 0) {
            sumNode = new ListNode(carry);
            currentNode.next = sumNode;
            currentNode = sumNode;
        }
        return  resultNodeHead;
    }

    public static void main(String[] args) {
        AddTwoNumbersInLinkedList mainObject = new AddTwoNumbersInLinkedList();
        /*ListNode l1 = mainObject.createListNode(new int[]{2,4,3});
        ListNode l2 = mainObject.createListNode(new int[]{5,6,4});*/
        ListNode l1 = mainObject.createListNode(new int[]{5});
        ListNode l2 = mainObject.createListNode(new int[]{5});

        System.out.println("---------------------");
        mainObject.printListNode(l1);
        mainObject.printListNode(l2);
        System.out.println("---------------------");
        ListNode resultNode = mainObject.addTwoNumbers(l1, l2);
        mainObject.printListNode(resultNode);
    }

    private ListNode createListNode(int[] ints) {
        ListNode head = null;
        ListNode current = null;
        ListNode node = null;
        for(int i=0; i < ints.length; i++) {
            node = new ListNode(ints[i]);
            if(head == null) {
                head = node;
                current = node;
            }else{
                current.next = node;
                current = node;
            }
        }
        return head;
    }

    private void printListNode(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val + " ->");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
