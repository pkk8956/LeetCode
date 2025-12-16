package String_Search;

import java.util.*;

public class AhoCorasick {

    // Time Complexity: O(N + M + Z) where N is length of haystack, M is total length of needles, Z is number of matches
    // Space Complexity: O(M)

    private static class Node {
        Map<Character, Node> next = new HashMap<>();
        Node failure;
        List<String> output = new ArrayList<>();
    }

    private final Node root = new Node();

    public void addNeedle(String needle) {
        Node node = root;
        for (char c : needle.toCharArray()) {
            node = node.next.computeIfAbsent(c, k -> new Node());
        }
        node.output.add(needle);
    }

    public void build() {
        Queue<Node> queue = new ArrayDeque<>();

        for (Node node : root.next.values()) {
            node.failure = root;
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Map.Entry<Character, Node> entry : current.next.entrySet()) {
                char c = entry.getKey();
                Node nextNode = entry.getValue();

                Node fail = current.failure;
                while (fail != null && !fail.next.containsKey(c)) {
                    fail = fail.failure;
                }

                nextNode.failure = (fail == null) ? root : fail.next.get(c);
                nextNode.output.addAll(nextNode.failure.output);

                queue.add(nextNode);
            }
        }
    }

    public Map<Integer, List<String>> search(String haystack) {
        Map<Integer, List<String>> result = new HashMap<>();

        Node node = root;

        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);

            while (node != root && !node.next.containsKey(c)) {
                node = node.failure;
            }

            if (node.next.containsKey(c)) {
                node = node.next.get(c);
            }

            if (!node.output.isEmpty()) {
                result.putIfAbsent(i, new ArrayList<>());
                result.get(i).addAll(node.output);
            }
        }

        return result;
    }

}
