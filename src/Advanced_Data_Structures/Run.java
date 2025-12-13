package Advanced_Data_Structures;

import java.util.Arrays;
import java.util.List;

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

        // Skip List Example
        SkipList skipList = new SkipList();
        skipList.insert(3);     
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        System.out.println(skipList.search(7));  
        System.out.println(skipList.search(15));
        skipList.delete(3);
        System.out.println(skipList.search(3));

        //ISAM Example
        List<Integer> data = Arrays.asList(1, 5, 10, 15, 20, 25, 30, 35);
        ISAM isam = new ISAM(data);
        System.out.println(isam.search(15));
        System.out.println(isam.search(17));
        isam.insert(17);
        isam.insert(18);
        isam.insert(19);
        System.out.println(isam.search(17));
        System.out.println(isam.search(19));

    
    }
}
