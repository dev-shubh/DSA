package graph;

import java.util.*;

public class Graph{
    private HashMap<Integer, Node> nodeLookUp = new HashMap<>();


    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookUp.get(id);
    }

    public void addEdge(int source, int destination) {
        Node src = nodeLookUp.get(source);
        Node dest = nodeLookUp.get(destination);
        src.adjacent.add(dest);
        dest.adjacent.add(src); // if this is undirected.
    }

    public boolean hasPathDFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(getNode(src), getNode(dest), visited);
    }

    private boolean hasPathDFS(Node src, Node dest, HashSet<Integer> visited) {
        if(visited.contains(src.id)) return false;
        visited.add(src.id);
        if (src == dest) return true;
        for(Node child : src.adjacent) {
            hasPathDFS(child, dest, visited);
        }
        return false;
    }

    public boolean hasPathBFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(getNode(src), getNode(dest), visited);
    }
    private boolean hasPathBFS(Node src, Node dest, HashSet<Integer> visited) {
        if(dest == src) return true;
        Queue<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(src);

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            visited.add(node.id);
            if (dest == node ) return true;
            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }

        return false;
    }

}
