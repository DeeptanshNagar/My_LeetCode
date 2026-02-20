class Solution {
    static class Fenwick {
        int n;
        int bit[];
        Fenwick(int n) {
            this.n = n;
            this.bit = new int[n + 1];
        }

        void add(int i, int val) {
            for (; i <= n; i += i & -i) bit[i] ^= val;
        }

        void range(int l, int r, int val) {
            add(l, val);
            add(r + 1, val);
        }

        int query(int i) {
            int ans = 0;
            for (; i > 0; i -= i & -i) ans ^= bit[i];
            return ans;
        }
    }

    int n, log, timer = 0;
    List<Integer>[] adj;
    int[] tin, tout, depth, mask;
    int up[][];
    char ch[];
    Fenwick bit;

    private void dfs(int u, int p, int curr) {
        tin[u] = ++timer;
        up[0][u] = (p == -1) ? u : p;
        mask[u] = curr ^ (1 << (ch[u] - 'a'));

        for (int v : adj[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u, mask[u]);
        }
        tout[u] = timer;
    }

    private void build() {
        for (int i = 1; i < log; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = up[i - 1][up[i - 1][j]];
            }
        }
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[a] - depth[b];
        for (int i = 0; i < log; i++) {
            if ((diff & (1 << i)) != 0) a = up[i][a];
        }
        if (a == b) return a;
        for (int i = log - 1; i >= 0; i--) {
            if (up[i][a] != up[i][b]) {
                a = up[i][a];
                b = up[i][b];
            }
        }
        return up[0][a];
    }
    
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        this.ch = s.toCharArray();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int edge[] : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        log = 1;
        while ((1 << log) <= n) log++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        mask = new int[n];
        up = new int[log][n];
        bit = new Fenwick(n + 1);

        dfs(0, -1, 0);
        build();

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            String comm[] = query.split(" ");
            if (comm[0].equals("update")) {
                int u = Integer.parseInt(comm[1]);
                char nc = comm[2].charAt(0);
                if (ch[u] != nc) {
                    int diff = (1 << (ch[u] - 'a')) ^ (1 << (nc - 'a'));
                    ch[u] = nc;
                    bit.range(tin[u], tout[u], diff);
                }
            }
            else {
                int u = Integer.parseInt(comm[1]);
                int v = Integer.parseInt(comm[2]);
                int w = lca(u, v);

                int curr = (mask[u] ^ bit.query(tin[u])) ^ (mask[v] ^ bit.query(tin[v])) ^ (1 << (ch[w] - 'a'));
                ans.add((curr & (curr - 1)) == 0);
            }
        }
        return ans;
    }
}