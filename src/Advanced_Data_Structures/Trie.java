package Advanced_Data_Structures;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean end;
}

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int i) {
        if (i == word.length()) {
            if (!node.end) return false;
            node.end = false;
            return node.children.isEmpty();
        }
        char c = word.charAt(i);
        TrieNode next = node.children.get(c);
        if (next == null) return false;
        boolean shouldDelete = delete(next, word, i + 1);
        if (shouldDelete) node.children.remove(c);
        return node.children.isEmpty() && !node.end;
    }
}
