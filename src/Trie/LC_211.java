package Trie;

public class LC_211 {

    // Design Add and Search Words Data Structure

    /*Design a data structure that supports adding new words and finding if a 
    string matches any previously added string.
    Implement the WordDictionary class:
        -- WordDictionary() Initializes the object.
        -- void addWord(word) Adds word to the data structure, it can be matched later.
        -- bool search(word) Returns true if there is any string in the data structure 
        that matches word or false otherwise. word may contain dots '.' where dots can 
        be matched with any letter.*/

    public static void main(String[] args) {
        LC_211 obj = new LC_211();
        WordDictionary wordDictionary = obj.new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    class WordDictionary {

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            boolean isWord;
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        // Adds a word into the Trie
        public void addWord(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
            }

            node.isWord = true;
        }

        // Searches a word with possible '.' wildcard
        public boolean search(String word) {
            return dfs(word, 0, root);
        }

         // DFS helper to handle '.' wildcard
        private boolean dfs(String word, int index, TrieNode node) {
            if (node == null) return false;

            if (index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);

            if (c == '.') {
                // Try all possible children
                for (int i = 0; i < 26; i++) {
                    if (node.next[i] != null) {
                        if (dfs(word, index + 1, node.next[i])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                return dfs(word, index + 1, node.next[c - 'a']);
            }
        }
    }
}
