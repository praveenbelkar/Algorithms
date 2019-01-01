package com.algorithm.praveen.graph;

import java.util.Arrays;

/**
 * Traverse through a graph in DFS manner
 */
public class DFS {

    public void dfs(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        Arrays.fill(visited, false);
        for(int vertex=0; vertex < graph.vertices; vertex++) {
            dfsUtil(vertex, visited, graph);
        }
    }

    private void dfsUtil(int vertex, boolean[] visited, Graph graph) {
        if(!visited[vertex]) {
          visited[vertex] = true;
            System.out.println(vertex);
            for(Integer adjNode: graph.adjListArray[vertex]) {
                dfsUtil(adjNode, visited, graph);
            }
        }
    }

    private Graph buildGraph() {
        Graph graph = new Graph(6);
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(1,3);
        graph.addEdges(1,4);
        graph.addEdges(3,5);
        graph.addEdges(4,5);
        return graph;
    }

    public static void main(String[] args) {
        DFS mainObject = new DFS();
        Graph graph = mainObject.buildGraph();
        mainObject.dfs(graph);
    }
}
