class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if ((n & (n - 1)) == 0 && Integer.bitCount(n - 1) % 2 == 0) return true;
        return false;
    }
}