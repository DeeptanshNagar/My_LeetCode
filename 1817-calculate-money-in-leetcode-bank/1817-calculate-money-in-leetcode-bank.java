class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 28 * weeks + (7 * weeks * (weeks - 1)) / 2;
        for (int i = 0; i < days; i++) {
            total += weeks + 1 + i;
        }

        return total;
    }
}
