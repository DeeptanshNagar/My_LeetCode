class Solution {
    private long factorial(int n) {
        if (n < 3) return n;
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = (ans * i) % 1000000007;
        }
        return ans % 1000000007;
    }
    int countPermutations(int[] complexity) {
        int temp = complexity[0];
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= temp) return 0;
        }
        return (int)factorial(n - 1);
    }
}