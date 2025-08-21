class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int height[] = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
            }
            ans += count(height);
        }
        return ans;
    }

    int count(int[] height) {
        int n = height.length, res = 0;
        int sum[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) stack.pop();
            if (!stack.isEmpty()) {
                int p = stack.peek();
                sum[i] = sum[p] + height[i] * (i - p);
            } 
            else sum[i] = height[i] * (i + 1);
            stack.push(i);
            res += sum[i];
        }
        return res;
    }
}