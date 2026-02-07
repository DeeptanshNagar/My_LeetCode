class Solution {
    public int minimumDeletions(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int prefA[] = new int[n + 1];
        int prefB[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefB[i + 1] = prefB[i] + ((arr[i] == 'b') ? 1 : 0);
        }
        for (int i = n; i > 0; i--) {
            prefA[i - 1] = prefA[i] + ((arr[i - 1] == 'a') ? 1 : 0);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) min = Math.min(prefA[i] + prefB[i], min);
        return min;
    }
}