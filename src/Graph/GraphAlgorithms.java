package Graph;

import java.util.*;

public class GraphAlgorithms {

    // -------- BFS ----------
    public static void bfs(Graph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (Graph.Edge edge : graph.getGraph().getOrDefault(node, List.of())) {
                if (!visited.contains(edge.to)) {
                    visited.add(edge.to);
                    queue.add(edge.to);
                }
            }
        }
        System.out.println();
    }

    // -------- DFS ----------
    public static void dfs(Graph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(graph, start, visited);
        System.out.println();
    }

    private static void dfsRecursive(Graph graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for (Graph.Edge edge : graph.getGraph().getOrDefault(node, List.of())) {
            dfsRecursive(graph, edge.to, visited);
        }
    }

    // -------- Dijkstra ----------
    public static Map<Integer, Integer> dijkstra(Graph graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int v : graph.getGraph().keySet()) distances.put(v, Integer.MAX_VALUE);
        distances.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            int distU = current.distance;
            if (distU > distances.get(u)) continue;

            for (Graph.Edge edge : graph.getGraph().getOrDefault(u, List.of())) {
                int v = edge.to;
                int weight = edge.weight;
                if (distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                    pq.add(new Node(v, distances.get(v)));
                }
            }
        }
        return distances;
    }

    private static class Node {
        int vertex;
        int distance;
        Node(int vertex, int distance) { this.vertex = vertex; this.distance = distance; }
    }

    // -------- Bellman-Ford ----------
    public static Map<Integer, Integer> bellmanFord(Graph graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int v : graph.getGraph().keySet()) distances.put(v, Integer.MAX_VALUE);
        distances.put(start, 0);

        int V = graph.getGraph().size();
        for (int i = 0; i < V - 1; i++) {
            for (var entry : graph.getGraph().entrySet()) {
                int u = entry.getKey();
                for (Graph.Edge edge : entry.getValue()) {
                    int v = edge.to;
                    int w = edge.weight;
                    if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + w < distances.get(v)) {
                        distances.put(v, distances.get(u) + w);
                    }
                }
            }
        }

        for (var entry : graph.getGraph().entrySet()) {
            int u = entry.getKey();
            for (Graph.Edge edge : entry.getValue()) {
                int v = edge.to;
                int w = edge.weight;
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + w < distances.get(v)) {
                    throw new RuntimeException("Graph contains negative cycle!");
                }
            }
        }

        return distances;
    }

    // -------- Topological Sort ----------
    public static List<Integer> topologicalSort(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int node : graph.getGraph().keySet()) {
            if (!visited.contains(node)) dfsTopo(graph, node, visited, stack);
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static void dfsTopo(Graph graph, int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);
        for (Graph.Edge edge : graph.getGraph().getOrDefault(node, List.of())) {
            if (!visited.contains(edge.to)) dfsTopo(graph, edge.to, visited, stack);
        }
        stack.push(node);
    }

    // -------- Detect Cycle in Directed Graph ----------
    public static boolean hasCycle(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : graph.getGraph().keySet()) {
            if (dfsCycle(graph, node, visited, recStack)) return true;
        }
        return false;
    }

    private static boolean dfsCycle(Graph graph, int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (Graph.Edge edge : graph.getGraph().getOrDefault(node, List.of())) {
            if (dfsCycle(graph, edge.to, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }

    // -------- Connected Components (Undirected) ----------
    public static List<Set<Integer>> connectedComponents(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        List<Set<Integer>> components = new ArrayList<>();

        for (int node : graph.getGraph().keySet()) {
            if (!visited.contains(node)) {
                Set<Integer> component = new HashSet<>();
                dfsComponent(graph, node, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    private static void dfsComponent(Graph graph, int node, Set<Integer> visited, Set<Integer> component) {
        visited.add(node);
        component.add(node);
        for (Graph.Edge edge : graph.getGraph().getOrDefault(node, List.of())) {
            if (!visited.contains(edge.to)) dfsComponent(graph, edge.to, visited, component);
        }
    }

    // -------- Floyd-Warshall ----------
    public static Map<Integer, Map<Integer, Integer>> floydWarshall(Graph graph) {
        Map<Integer, Map<Integer, Integer>> dist = new HashMap<>();
        Set<Integer> vertices = graph.getGraph().keySet();

        for (int u : vertices) {
            dist.put(u, new HashMap<>());
            for (int v : vertices) {
                if (u == v) dist.get(u).put(v, 0);
                else dist.get(u).put(v, Integer.MAX_VALUE);
            }
            for (Graph.Edge edge : graph.getGraph().getOrDefault(u, List.of())) {
                dist.get(u).put(edge.to, edge.weight);
            }
        }

        for (int k : vertices) {
            for (int i : vertices) {
                for (int j : vertices) {
                    int ik = dist.get(i).get(k);
                    int kj = dist.get(k).get(j);
                    int ij = dist.get(i).get(j);
                    if (ik != Integer.MAX_VALUE && kj != Integer.MAX_VALUE && ik + kj < ij) {
                        dist.get(i).put(j, ik + kj);
                    }
                }
            }
        }

        return dist;
    }

    // -------- Prim's MST (Undirected, Weighted) ----------
    public static Set<String> primMST(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<EdgePrim> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> mst = new HashSet<>();

        int start = graph.getGraph().keySet().iterator().next();
        visited.add(start);
        for (Graph.Edge e : graph.getGraph().get(start)) pq.add(new EdgePrim(start, e.to, e.weight));

        while (!pq.isEmpty()) {
            EdgePrim edge = pq.poll();
            if (visited.contains(edge.to)) continue;
            visited.add(edge.to);
            mst.add(edge.from + "->" + edge.to + "(" + edge.weight + ")");
            for (Graph.Edge e : graph.getGraph().get(edge.to)) {
                if (!visited.contains(e.to)) pq.add(new EdgePrim(edge.to, e.to, e.weight));
            }
        }
        return mst;
    }

    private static class EdgePrim {
        int from, to, weight;
        EdgePrim(int f, int t, int w) { from=f; to=t; weight=w; }
    }

    // -------- Kruskal's MST (Undirected, Weighted) ----------
    public static Set<String> kruskalMST(Graph graph) {
        List<EdgeKruskal> edges = new ArrayList<>();
        for (var entry : graph.getGraph().entrySet()) {
            int u = entry.getKey();
            for (Graph.Edge e : entry.getValue()) {
                int v = e.to;
                if (u < v) edges.add(new EdgeKruskal(u,v,e.weight));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind uf = new UnionFind(graph.getGraph().size()+1);
        Set<String> mst = new HashSet<>();

        for (EdgeKruskal e : edges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e.u + "-" + e.v + "(" + e.weight + ")");
            }
        }
        return mst;
    }

    private static class EdgeKruskal { int u,v,weight; EdgeKruskal(int u,int v,int w){this.u=u;this.v=v;this.weight=w;} }
    private static class UnionFind {
        int[] parent; UnionFind(int n){parent=new int[n]; for(int i=0;i<n;i++) parent[i]=i;}
        int find(int x){if(parent[x]!=x) parent[x]=find(parent[x]); return parent[x];}
        boolean union(int a,int b){int pa=find(a),pb=find(b); if(pa==pb) return false; parent[pa]=pb; return true;}
    }

    // -------- Strongly Connected Components (Kosaraju) ----------
    public static List<Set<Integer>> stronglyConnectedComponents(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int node : graph.getGraph().keySet()) {
            if (!visited.contains(node)) dfsTopo(graph, node, visited, stack);
        }

        Graph transposed = transposeGraph(graph);
        visited.clear();
        List<Set<Integer>> scc = new ArrayList<>();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                Set<Integer> component = new HashSet<>();
                dfsComponent(transposed, node, visited, component);
                scc.add(component);
            }
        }
        return scc;
    }

    private static Graph transposeGraph(Graph graph) {
        Graph transposed = new DirectedGraph();
        for (int node : graph.getGraph().keySet()) transposed.addVertex(node);
        for (var entry : graph.getGraph().entrySet()) {
            int u = entry.getKey();
            for (Graph.Edge e : entry.getValue()) {
                transposed.addEdge(e.to, u, e.weight);
            }
        }
        return transposed;
    }

}
