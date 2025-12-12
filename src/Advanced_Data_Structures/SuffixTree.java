package Advanced_Data_Structures;

import java.util.HashMap;
import java.util.Map;

class SuffixNode {
    Map<Character, SuffixNode> children = new HashMap<>();
}

public class SuffixTree {
    private final SuffixNode root = new SuffixNode();

    public void build(String s) {
        for (int i = 0; i < s.length(); i++) {
            SuffixNode node = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                node = node.children.computeIfAbsent(c, k -> new SuffixNode());
            }
        }
    }

    public boolean search(String sub) {
        SuffixNode node = root;
        for (char c : sub.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return true;
    }
}

