package graph;

import java.util.LinkedList;

public class UndirectedGraph {
    private int v;
    private LinkedList<Integer> [] adjacencyList;

    public UndirectedGraph(int v) {
        this.v = v;
        for(int i=0; i<v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
        adjacencyList[dest].add(src);
    }

    public boolean hasEdge(int src, int dest) {
        for(Integer vertices : adjacencyList[src]) {
            if(vertices == dest) {
                return true;
            }
        }
        return false;
    }
}
