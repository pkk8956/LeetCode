package Trie;

import java.util.ArrayList;
import java.util.List;

public class LC_212 {

    // Word Search II

    /*Given an m x n board of characters and a list of strings words, return all words on the board.
    Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are 
    horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.*/

    public static void main(String[] args) {
        LC_212 obj = new LC_212();
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(obj.findWords(board, words));
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26]; // children for each letter
        String word; // stores full word when a word ends here
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        
       // Build Trie from the list of words
        for (String word : words) insert(word);

        // Start DFS from every cell on the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return result; 
    }

    void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
        }

        // Mark the end of a word
        node.word = word;
    }

    void dfs(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];

        // Stop if visited or no matching Trie path
        if (c == '#' || node.next[c - 'a'] == null) return;

        node = node.next[c - 'a'];

        // If a complete word is found, add to result
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        // Mark current cell as visited
        board[i][j] = '#';

        // Explore all 4 directions
        if (i > 0) dfs(board, i - 1, j, node);
        if (j > 0) dfs(board, i, j - 1, node);
        if (i < board.length - 1) dfs(board, i + 1, j, node);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node);

        // Restore original character after DFS
        board[i][j] = c;
    }
    
}
