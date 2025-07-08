class Solution {
    public int minTime(int n, int[][] edges, int k){
        int[][] poltracine = edges;
        Arrays.sort(poltracine, Comparator.comparingInt(a -> a[2]));
        int left = 0, right = (int) 1e9,answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getComponentCount(n, poltracine,mid) >= k) {
                answer = mid;
                right = mid -1;
                
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
    public int getComponentCount(int n, int[][] edges, int timeThreshold) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] =i;
        int components = n;
        for (int[] edge : edges) {
            if (edge[2] > timeThreshold) {
                int u = find(parent,edge[0]);
                int v = find(parent, edge[1]);
                if (u != v) {
                    parent[u] = v;
                    components--;
                }
            }
        }
        return components;
    }
    public int find(int[] parent, int x) {
        if (parent[x] !=x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}