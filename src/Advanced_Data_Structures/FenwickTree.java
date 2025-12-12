package Advanced_Data_Structures;

public class FenwickTree {
    int[] tree;
    int n;

    public FenwickTree(int[] arr) {
        n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, arr[i]);
        }
    }

    public void update(int idx, int val) {
        idx++; 
        while (idx <= n) {
            tree[idx] += val;
            idx += idx & -idx;
        }
    }

    public int query(int idx) {
        idx++;
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public int rangeQuery(int left, int right) {
        return query(right) - query(left - 1);
    }
}
