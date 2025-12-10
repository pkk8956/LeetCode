package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LC_1466 {

    // Reorder Routes to Make All Paths Lead to the City Zero

    /* There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel 
    between two different cities (this network form a tree).
    Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
    Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.
    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
    Your task consists of reorienting some roads such that each city can visit the city 0.
    Return the minimum number of edges changed.*/

    public static void main(String[] args) {
        LC_1466 obj = new LC_1466();
        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };
        int result = obj.minReorder(n, connections);
        System.out.println("Minimum edges to change: " + result);
    }


    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> directedEdges = new HashSet<>();

        for (int[] conn : connections) {
            graph.putIfAbsent(conn[0], new ArrayList<>());
            graph.putIfAbsent(conn[1], new ArrayList<>());
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(conn[0]);
            directedEdges.add(conn[0] + "->" + conn[1]);
        }

        return dfs(0, visited, graph, directedEdges);
    }

    private int dfs(int city, boolean[] visited, Map<Integer, List<Integer>> graph, Set<String> directedEdges) {
        visited[city] = true;
        int changes = 0;

        for (int neighbor : graph.getOrDefault(city, new ArrayList<>())) {
            if (!visited[neighbor]) {
                if (directedEdges.contains(city + "->" + neighbor)) {
                    changes++;
                }
                changes += dfs(neighbor, visited, graph, directedEdges);
            }
        }
        return changes;
    }
    
}
