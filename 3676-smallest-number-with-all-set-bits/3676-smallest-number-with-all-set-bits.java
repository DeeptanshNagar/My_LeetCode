class Solution {
    public int smallestNumber(int n) {
        for (int i = 1; i <= 30; i++) {
            int temp = (int)Math.pow(2, i);
            if (temp > n) return temp - 1;
        }
        return -1;
    }
}