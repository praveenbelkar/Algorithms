package com.algorithm.praveen.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * class to represent the Graph
 */
public class Graph {
    int vertices;
    List<Integer> adjListArray[];

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjListArray = new LinkedList[vertices];
        for(int i=0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdges(int src, int dest) {
        adjListArray[src].add(dest);
    }
}
