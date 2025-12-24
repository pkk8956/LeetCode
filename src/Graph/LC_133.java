package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_133 {

    //Clone Graph

    /*Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
        class Node {
            public int val;
            public List<Node> neighbors;
        } */

    public static void main(String[] args) {
        LC_133 obj = new LC_133();
        int[][] adjList = {
            {2, 4},
            {1, 3},
            {2, 4},
            {1, 3}
        };

        int n = adjList.length;
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) nodes[i] = new Node(i);

        // Build neighbors
        for (int i = 1; i <= n; i++) {
            for (int neighbor : adjList[i - 1]) {
                nodes[i].neighbors.add(nodes[neighbor]);
            }
        }

        Node node = nodes[1];
        System.out.println(node != obj.cloneGraph(node));
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // Return cloned node if already visited
        if (map.containsKey(node)) return map.get(node);

        // Create clone
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Clone neighbors
        for (Node neighbor : node.neighbors) clone.neighbors.add(dfs(neighbor, map));

        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
