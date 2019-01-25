package com.algorithm.praveen.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 *
 * Algorithm:
 Steps involved in finding the topological ordering of a DAG:

 Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.

 Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

 Step-3: Remove a vertex from the queue (Dequeue operation) and then.

 Increment count of visited nodes by 1.
 Decrease in-degree by 1 for all its neighboring nodes.
 If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
 Step 5: Repeat Step 3 until the queue is empty.

 Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
 */

public class TopologicalSortKahn {

    public int[] topologicalSort(Graph graph){
        int[] result = new int[graph.vertices];
        int[] inOrder = calculateInorder(graph);
        int visitedVertex = 0;
        int position = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        while(zeroInOrderVerticesPresent(inOrder)){
            int zeroInOrderVertex = getZeroInOrderVertex(inOrder);
            queue.add(zeroInOrderVertex);
            while(!queue.isEmpty()){
                zeroInOrderVertex = queue.poll();
                result[position++] = zeroInOrderVertex;
                visitedVertex++;
                decreaseInOrderForNeighbouringNodesByOne(zeroInOrderVertex, inOrder, graph, queue);
            }
        }
        if(visitedVertex != graph.vertices){
            System.out.println("Topological sorting not possible");
            return null;
        }
        return result;
    }

    private boolean zeroInOrderVerticesPresent(int[] inOrder) {
        for(Integer element: inOrder){
            if(element == 0){
                return true;
            }
        }
        return false;
    }

    private void decreaseInOrderForNeighbouringNodesByOne(int zeroInOrderVertex, int[] inOrder, Graph graph, LinkedList<Integer> queue) {
        List<Integer> neighbouringNodes = graph.adjListArray[zeroInOrderVertex];
        for(Integer neighbouringNode: neighbouringNodes){
            inOrder[neighbouringNode]--;
            if(inOrder[neighbouringNode] == 0){
                queue.addLast(neighbouringNode);
                inOrder[neighbouringNode] = -1;
            }
        }
    }

    private int getZeroInOrderVertex(int[] inOrder) {
        for(int i=0; i<inOrder.length; i++){
            if(inOrder[i] == 0){
                inOrder[i] = -1;
                return i;
            }
        }
        return -1;
    }

    private int[] calculateInorder(Graph graph) {
        int[] inOrder = new int[graph.vertices];
        Arrays.fill(inOrder, 0);
        for(int i=0; i < graph.adjListArray.length; i++){
            List<Integer> adjList = graph.adjListArray[i];
            for(Integer targetVertex: adjList){
               inOrder[targetVertex]++;
            }
        }
        Arrays.stream(inOrder).forEach(element -> System.out.print(element + " "));
        System.out.println();
        return inOrder;
    }

    private Graph buildGraph() {
        Graph graph = new Graph(6);
        graph.addEdges(5,0);
        graph.addEdges(5,2);
        graph.addEdges(4,0);
        graph.addEdges(4,1);
        graph.addEdges(2,3);
        graph.addEdges(3,1);
        return graph;
    }

    public static void main(String[] args) {
        TopologicalSortKahn mainObject = new TopologicalSortKahn();
        Graph graph = mainObject.buildGraph();
        int[] result = mainObject.topologicalSort(graph);
        Arrays.stream(result).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
