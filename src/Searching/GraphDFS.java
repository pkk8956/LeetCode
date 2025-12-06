package Searching;

import java.util.*;

public class GraphDFS {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : graph.getOrDefault(node, List.of())) {
            if (!visited.contains(neighbor)) dfs(neighbor, visited);
        }
    }

    public void startDFS(int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited);
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        System.out.print("DFS starting from node 1: ");
        g.startDFS(1);
    }
}
