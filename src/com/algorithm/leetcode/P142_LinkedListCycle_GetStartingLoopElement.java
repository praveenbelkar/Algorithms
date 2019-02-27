package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class P142_LinkedListCycle_GetStartingLoopElement {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode cycleDetectedNode = checkIfCyclePresent(head);
        if(cycleDetectedNode != null) {
            ListNode start = head;
            while(start != cycleDetectedNode) {
                start = start.next;
                cycleDetectedNode = cycleDetectedNode.next;
            }
            return start;
        }
        return null;
    }

    private ListNode checkIfCyclePresent(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            if(slow == fast) {
                return slow;
            }
        }
        return null;
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

    private ListNode getLastNode(ListNode head) {
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        P142_LinkedListCycle_GetStartingLoopElement mainObject = new P142_LinkedListCycle_GetStartingLoopElement();
        ListNode head = mainObject.createList(new int[]{1,2,3,4,5});
        ListNode lastNode = mainObject.getLastNode(head);
        lastNode.next = head.next.next;
        System.out.println(mainObject.detectCycle(head));

    }
}
