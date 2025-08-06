class Solution {
    int n;
    int seg[];

    private void update(int p) { 
        seg[p] = Math.max(seg[p << 1], seg[p << 1 | 1]); 
    }

    private void build(int p, int l, int r, int[] baskets) {
        if (l == r) {
            seg[p] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid, baskets);
        build(p << 1 | 1, mid + 1, r, baskets);
        update(p);
    }

    private void assign(int x, int v, int p, int l, int r) {
        if (x < l || x > r) return;
        if (l == r) {
            seg[p] = v;
            return;
        }
        int mid = (l + r) >> 1;
        assign(x, v, p << 1, l, mid);
        assign(x, v, p << 1 | 1, mid + 1, r);
        update(p);
    }

    private int firstLarger(int v, int p, int l, int r) {
        if (seg[p] < v) return r + 1;
        if (l == r) return r;
        int mid = (l + r) >> 1;
        int lf = firstLarger(v, p << 1, l, mid);
        if (lf <= mid) return lf;
        return firstLarger(v, p << 1 | 1, mid + 1, r);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = fruits.length;
        seg = new int[4 * n + 1];
        build(1, 0, n - 1, baskets);
        int res = 0;
        for (int x : fruits) {
            int pos = firstLarger(x, 1, 0, n - 1);
            if (pos == n) res++;
            else assign(pos, 0, 1, 0, n - 1);
        }
        return res;
    }
}