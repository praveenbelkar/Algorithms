package com.algorithm.praveen.graph;

import java.util.Arrays;

/**
 * Determine if there exists a cycle in a directed graph
 */
public class CycleDetectionDirectedGraph {

    public boolean detectCycle(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        boolean[] recStack = new boolean[graph.vertices];

        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);
        //This is useful for disconnected graphs
        for(int i=0; i < graph.vertices; i++) {
            if(detectCycleUtil(i, visited, recStack, graph)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleUtil(int vertex, boolean[] visited, boolean[] recStack, Graph graph) {
        if(!visited[vertex]) {
            visited[vertex] = true;
            recStack[vertex] = true;

            //Recursively check for all the adjacent nodes of vertex
            for(Integer adjNode: graph.adjListArray[vertex]) {
                //check for back edge i.e.
                if(!visited[adjNode] && detectCycleUtil(adjNode, visited, recStack, graph)) {
                    return true;
                } else if(recStack[adjNode]) {
                    return true;
                }
            }
        }
        recStack[vertex] = false;
        return false;
    }

    private Graph buildGraph() {
        Graph graph = new Graph(4);
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(1,2);
        graph.addEdges(2,0);
        graph.addEdges(2,3);
        graph.addEdges(3,3);
        return graph;
    }

    public static void main(String[] args) {
        CycleDetectionDirectedGraph mainObject = new CycleDetectionDirectedGraph();
        Graph graph = mainObject.buildGraph();
        System.out.println(mainObject.detectCycle(graph));
    }


}
