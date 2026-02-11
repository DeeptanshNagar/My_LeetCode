class SegmentTree {
    public int n;
    public int[] sum, min, max;

    SegmentTree(int n_) {
        n = n_;
        sum = new int[4 * n];
        min  = new int[4 * n];
        max  = new int[4 * n];
    }

    void pull(int node) {
        int lc = node * 2, rc = node * 2 + 1;
        sum[node] = sum[lc] + sum[rc];
        min[node] = Math.min(min[lc], sum[lc] + min[rc]);
        max[node] = Math.max(max[lc], sum[lc] + max[rc]);
    }

    void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            sum[node] = val;
            min[node] = val;
            max[node] = val;
            return;
        }

        int mid = (l + r) / 2;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        pull(node);
    }

    boolean exist(int node, int sum_before, int target) {
        int need = target - sum_before;
        return min[node] <= need && need <= max[node];
    }

    int find_rightmost_prefix(int target) {
        return find_rightmost_prefix(1, 0, n - 1, 0, target);
    }

    int find_rightmost_prefix(int node, int l, int r, int sum_before, int target) {
        if (!exist(node, sum_before, target)) return -1;
        if (l == r) return l;

        int m = (l + r) / 2;
        int lc = node * 2, rc = node * 2 + 1;

        int sum_before_right = sum_before + sum[lc];
        if (exist(rc, sum_before_right, target)) return find_rightmost_prefix(rc, m + 1, r, sum_before_right, target);

        return find_rightmost_prefix(lc, l, m, sum_before, target);
    }
}

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        SegmentTree stree = new SegmentTree(n);
        HashMap<Integer, Integer> first = new HashMap<>();

        int result = 0;
        for (int l = n - 1; l >= 0; --l) {
            int x = nums[l];

            Integer old = first.get(x);
            if (old != null) stree.update(old, 0);

            first.put(x, l);
            stree.update(l, ((x & 1) == 0) ? 1 : -1);

            int r = stree.find_rightmost_prefix(0);
            if (r >= l) result = Math.max(result, r - l + 1);
        }

        return result;
    }
}