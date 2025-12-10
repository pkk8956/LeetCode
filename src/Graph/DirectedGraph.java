package Graph;

import java.util.*;

public class DirectedGraph implements Graph {
    private final Map<Integer, List<Edge>> graph = new HashMap<>();

    @Override
    public void addVertex(int v) {
        graph.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());
        graph.get(from).add(new Edge(to, weight));
    }

    @Override
    public Map<Integer, List<Edge>> getGraph() {
        return graph;
    }

    @Override
    public void print() {
        for (var entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (var edge : entry.getValue()) {
                System.out.print("(" + edge.to + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
