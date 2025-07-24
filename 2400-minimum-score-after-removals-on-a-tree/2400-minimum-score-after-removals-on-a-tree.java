class Solution {
    private int sub[];
    private Set<Integer>[] descendants;
    private List<Integer>[] graph;

    private void dfs(int node, int parent, int[] nums) {
        sub[node] = nums[node];
        descendants[node].add(node);

        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums);
                sub[node] ^= sub[neighbor];
                descendants[node].addAll(descendants[neighbor]);
            }
        }
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int edge[] : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        sub = new int[n];
        descendants = new HashSet[n];
        for (int i = 0; i < n; i++) {
            descendants[i] = new HashSet<>();
        }

        dfs(0, -1, nums);

        int total = sub[0];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xorI = sub[i];
                int xorJ = sub[j];
                int val1, val2, val3;

                if (descendants[i].contains(j)) {
                    val1 = xorJ;
                    val2 = xorI ^ xorJ;
                    val3 = total ^ xorI;
                } 
                else if (descendants[j].contains(i)) { 
                    val1 = xorI;
                    val2 = xorJ ^ xorI;
                    val3 = total ^ xorJ;
                } 
                else {
                    val1 = xorI;
                    val2 = xorJ;
                    val3 = total ^ xorI ^ xorJ;
                }
                
                int maxVal = Math.max(val1, Math.max(val2, val3));
                int minVal = Math.min(val1, Math.min(val2, val3));
                min = Math.min(min, maxVal - minVal);
            }
        }

        return min;
    }
}