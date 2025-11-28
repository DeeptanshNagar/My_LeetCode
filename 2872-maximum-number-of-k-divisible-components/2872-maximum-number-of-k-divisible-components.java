class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n < 2) return 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int degree[] = new int[n];
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        long nodeVals[] = new long[n];
        for (int i = 0; i < n; i++) nodeVals[i] = values[i];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (degree[i] == 1) q.add(i);
        
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            degree[curr]--;
            long carry = 0;
            
            if (nodeVals[curr] % k == 0) count++;
            else carry = nodeVals[curr];
            
            for (int nbr : graph.get(curr)) {
                if (degree[nbr] == 0) continue;
                degree[nbr]--;
                nodeVals[nbr] += carry;
                if (degree[nbr] == 1) q.add(nbr);
            }
        }
        
        return count;
    }
}