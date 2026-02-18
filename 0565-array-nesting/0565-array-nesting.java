class Solution {
    boolean visited[];

    private int dfs(int nums[], int node) {
        if (visited[node]) return 0;
        if (nums[node] == node) return 1;
        visited[node] = true;
        return dfs(nums, nums[node]) + 1;
    }

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int curr = dfs(nums, i);
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}