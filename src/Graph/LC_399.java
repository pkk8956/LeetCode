package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC_399 {

    // Evaluate Division

    /* You are given equations in the format A / B = k,
    where A and B are variables represented as strings, and k is a real number (floating-point number).
    Given some queries, return the answers. If the answer does not exist, return -1.0. */

   public static void main(String[] args) {
        LC_399 obj = new LC_399();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = obj.calcEquation(equations, values, queries);

        System.out.print("Query results: ");
        for (double res : result) {
            System.out.print(res + " ");
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            res[i] = dfs(src, dst, graph, new HashSet<>(), 1.0);
        }

        return res;
    }

    private double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited, double acc) {
        if (!graph.containsKey(src)) return -1.0;
        if (src.equals(dst)) return acc;

        visited.add(src);

        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), dst, graph, visited, acc * neighbor.getValue());
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }
}
