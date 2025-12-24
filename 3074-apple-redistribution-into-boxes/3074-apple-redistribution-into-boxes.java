class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int i : apple) total += i;
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            total -= capacity[i];
            ans++;
            if (total <= 0) break;
        }
        return ans;
    }
}