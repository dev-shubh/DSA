package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSUG {
    void BFS(UndirectedGraph graph) {
        int source = 0;
        BFS(graph, source);
    }

    void BFS(UndirectedGraph graph, Integer src) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> nextToVisit = new LinkedList<>();
        nextToVisit.add(src);

        while (!nextToVisit.isEmpty()) {
            int current = nextToVisit.remove();
            if(!visited.contains(current)) {
                visited.add(current);
            }
        }
    }
}
