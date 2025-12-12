package Advanced_Data_Structures;

public class LC_208 {

    //Implement Trie (Prefix Tree)

    /*A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
    and retrieve keys in a dataset of strings. There are various applications of this data structure,
    such as autocomplete and spellchecker. Implement the Trie class:
        -- Trie() Initializes the trie object.
        -- void insert(String word) Inserts the string word into the trie.
        -- boolean search(String word) Returns true if the string word is in the 
        trie (i.e., was inserted before), and false otherwise.
        -- boolean startsWith(String prefix) Returns true if there is a previously inserted string 
        word that has the prefix prefix, and false otherwise.*/

    public static void main(String[] args) {
        LC_208 obj = new LC_208();  
        Trie trie = obj.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  
        System.out.println(trie.search("app"));     
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    class Trie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a'; 
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true; 
        }
    
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return node.isEnd;
        }
    
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return true;
        }
    }
}
