class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long total = 0;
        for (int battery : batteries){
            total += battery;
        }
        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > total / n) {
                total -= batteries[i];
                n--;
            }
            else break;
        }
        return total/n;
    }
}