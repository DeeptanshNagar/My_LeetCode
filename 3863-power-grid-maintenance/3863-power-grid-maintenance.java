class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] parent = new int[c + 1];
        for (int i = 1; i<=c; i++) parent[i] = i;
        Function<Integer, Integer> find = new Function<>() {
            public Integer apply(Integer x) {
                if (parent[x] != x) parent[x] = apply(parent[x]);
                return parent[x];
            }
        };
        for (int[] conn :connections) {
            int u = find.apply(conn[0]), v = find.apply(conn[1]);
            if (u != v) parent[v] = u;
        }
        Map<Integer, TreeSet<Integer>> componentMap = new HashMap<>();
        for (int i = 1; i<=c; i++) {
            int root = find.apply(i);
            componentMap.putIfAbsent(root, new TreeSet<>());
            componentMap.get(root).add(i);
        }
        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x= q[1], root = find.apply(x);
            if (type == 1) {
                if (isOnline[x]) res.add(x);
                else {
                    TreeSet<Integer> set = componentMap.get(root);
                    res.add(set == null || set.isEmpty() ? -1 : set.first());
                }
            } else if (type == 2 && isOnline[x]) {
                isOnline[x] = false;
                TreeSet<Integer> set =componentMap.get(root);
                if (set != null) set.remove(x);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}