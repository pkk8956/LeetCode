package Advanced_Data_Structures;

public class Run {

    public static void main(String[] args) {

        // Trie Example
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cat");
        trie.insert("dog");
        System.out.println(trie.search("car"));
        System.out.println(trie.search("cap"));
        System.out.println(trie.startsWith("ca"));
        trie.delete("car");
        System.out.println(trie.search("car"));
        System.out.println(trie.search("cat"));

        // Segment Tree Example
        int[] arr = {2, 5, 1, 4};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.query(0, 3));
        System.out.println(st.query(1, 2));
        st.update(1, 10);
        System.out.println(st.query(0, 3));
        System.out.println(st.query(1, 1));

        // Fenwick Tree Example
        FenwickTree ft = new FenwickTree(arr);
        System.out.println(ft.rangeQuery(0, 3));
        System.out.println(ft.rangeQuery(1, 2));
        ft.update(1, 10);
        System.out.println(ft.rangeQuery(0, 3));
        System.out.println(ft.rangeQuery(1, 1));

        // Disjoint Set Example
        DisjointSet ds = new DisjointSet(5);
        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        System.out.println(ds.connected(0, 2)); 
        System.out.println(ds.connected(0, 3)); 
        ds.union(2, 4);
        System.out.println(ds.connected(0, 4)); 

        // Suffix Tree Example
        String text = "banana$";
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.build(text);
        System.out.println(suffixTree.search("ana"));  
        System.out.println(suffixTree.search("nana")); 
        System.out.println(suffixTree.search("apple")); 
    }
}
