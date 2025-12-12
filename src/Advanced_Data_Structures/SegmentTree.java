package Advanced_Data_Structures;

public class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * node + 1, l, mid);
        build(arr, 2 * node + 2, mid + 1, r);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int l, int r, int left, int right) {
        if (left > r || right < l) return 0;
        if (left <= l && r <= right) return tree[node];
        int mid = (l + r) / 2;
        return query(2 * node + 1, l, mid, left, right)
             + query(2 * node + 2, mid + 1, r, left, right);
    }

    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int l, int r, int idx, int value) {
        if (l == r) {
            tree[node] = value;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(2 * node + 1, l, mid, idx, value);
        else update(2 * node + 2, mid + 1, r, idx, value);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
}
