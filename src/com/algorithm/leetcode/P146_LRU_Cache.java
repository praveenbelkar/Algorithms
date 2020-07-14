package com.algorithm.leetcode;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=kx-XDoPjoHw&t=865s
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 / capacity / );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
public class P146_LRU_Cache {

    public class Node {
        int key;
        int value;

        public boolean equals(Node other) {
            if(other == null) {
                return false;
            }

            if(this.key == other.key && this.value == other.value) {
                return true;
            }

            return false;
        }
    }

    Deque<Node> valueList;
    Map<Integer, Node> map = new HashMap<>();
    int maxCapacity = 0;
    int currentCapacity = 0;

    public P146_LRU_Cache(int capacity) {
        valueList =  new LinkedList<Node>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node valueNode = map.get(key);
        valueList.remove(valueNode);
        valueList.add(valueNode);
        return valueNode.value;
    }

    public void put(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;

        if(!map.containsKey(key)) {
            if(currentCapacity + 1 > maxCapacity) {
                currentCapacity = maxCapacity;
                map.remove(valueList.remove().key);
            } else {
                currentCapacity++;
            }
            map.put(key, node);
            valueList.add(node);
        } else{
            Node oldNode = map.get(key);
            valueList.remove(oldNode);
            valueList.add(node);
            map.put(key, node);
        }

    }

    public static void main(String[] args) {
        P146_LRU_Cache cache = new P146_LRU_Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
/*
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
*/
    }
}
