class Solution {
    public int sumBase(int n, int k) {
        int dips = 0;
        while(n > 0) {
            dips = dips + (n % k);
            n = n / k;
        }
        return dips;
    }
}