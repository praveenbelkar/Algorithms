package com.algorithm.praveen.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void bfs(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        Arrays.fill(visited, false);
        for(int vertex=0; vertex < graph.vertices; vertex++) {
            bfsUtil(vertex, visited, graph);
        }
    }

    public void bfsUtil(int vertex, boolean[] visited, Graph graph) {
        if(!visited[vertex]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            visited[vertex] = true;

            while(!queue.isEmpty()) {
                int element = queue.poll();
                System.out.print(element + " ");

                for(Integer adjcentNode: graph.adjListArray[element]) {
                    if(!visited[adjcentNode]) {
                        queue.add(adjcentNode);
                        visited[adjcentNode] = true;
                    }
                }
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
        BFS mainObject = new BFS();
        Graph graph = mainObject.buildGraph();
        mainObject.bfs(graph);
    }

}
