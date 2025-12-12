package Advanced_Data_Structures;

public class SegmentTreeLazy {
    int[] tree, lazy;
    int n;

    public SegmentTreeLazy(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
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

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            tree[node] += (r - l + 1) * lazy[node];
            if (l != r) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    public void updateRange(int left, int right, int val) {
        updateRange(0, 0, n - 1, left, right, val);
    }

    private void updateRange(int node, int l, int r, int left, int right, int val) {
        push(node, l, r);
        if (left > r || right < l) return;
        if (left <= l && r <= right) {
            lazy[node] += val;
            push(node, l, r);
            return;
        }
        int mid = (l + r) / 2;
        updateRange(2 * node + 1, l, mid, left, right, val);
        updateRange(2 * node + 2, mid + 1, r, left, right, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int l, int r, int left, int right) {
        push(node, l, r);
        if (left > r || right < l) return 0;
        if (left <= l && r <= right) return tree[node];
        int mid = (l + r) / 2;
        return query(2 * node + 1, l, mid, left, right)
             + query(2 * node + 2, mid + 1, r, left, right);
    }
}
