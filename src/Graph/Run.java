package Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Run {

    public static void main(String[] args) {

        // -------- Undirected Graph --------
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addEdge(1, 2, 5);
        undirectedGraph.addEdge(1, 3, 2);
        undirectedGraph.addEdge(2, 3, 1);
        undirectedGraph.addEdge(2, 4, 7);

        System.out.println("Undirected Graph:");
        undirectedGraph.print();

        System.out.print("BFS: ");
        GraphAlgorithms.bfs(undirectedGraph, 1);

        System.out.print("DFS: ");
        GraphAlgorithms.dfs(undirectedGraph, 1);

        System.out.println("Prim MST: " + GraphAlgorithms.primMST(undirectedGraph));
        System.out.println("Kruskal MST: " + GraphAlgorithms.kruskalMST(undirectedGraph));

        Map<Integer, Map<Integer, Integer>> fwUndirected = GraphAlgorithms.floydWarshall(undirectedGraph);
        System.out.println("Floyd-Warshall distances: " + fwUndirected);

        List<Set<Integer>> ccUndirected = GraphAlgorithms.connectedComponents(undirectedGraph);
        System.out.println("Connected Components: " + ccUndirected);


        System.out.println("\n-----------------------------\n");

        // -------- Directed Graph --------
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge(1, 2, 5);
        directedGraph.addEdge(1, 3, 2);
        directedGraph.addEdge(2, 4, 7);
        directedGraph.addEdge(3, 4, 1);

        System.out.println("Directed Graph:");
        directedGraph.print();

        System.out.print("BFS: ");
        GraphAlgorithms.bfs(directedGraph, 1);

        System.out.print("DFS: ");
        GraphAlgorithms.dfs(directedGraph, 1);

        Map<Integer, Map<Integer, Integer>> fwDirected = GraphAlgorithms.floydWarshall(directedGraph);
        System.out.println("Floyd-Warshall distances: " + fwDirected);

        List<Set<Integer>> ccDirected = GraphAlgorithms.connectedComponents(directedGraph);
        System.out.println("Connected Components: " + ccDirected);

        List<Set<Integer>> scc = GraphAlgorithms.stronglyConnectedComponents(directedGraph);
        System.out.println("Strongly Connected Components: " + scc);
    }
}
