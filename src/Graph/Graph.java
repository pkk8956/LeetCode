package Graph;

import java.util.*;

public interface Graph {
    void addVertex(int v);
    void addEdge(int from, int to, int weight);
    void print();
    Map<Integer, List<Edge>> getGraph();

    class Edge {
        public final int to;
        public final int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
