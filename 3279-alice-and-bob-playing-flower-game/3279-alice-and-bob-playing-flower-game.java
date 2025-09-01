class Solution {
    public long flowerGame(int n, int m) {
        long evenN = n / 2;
        long oddN = ((n & 1) == 0) ? (n / 2) : (n / 2) + 1;
        long evenM = m / 2;
        long oddM = ((m & 1) == 0) ? (m / 2) : (m / 2) + 1;

        return (evenN * oddM) + (evenM * oddN);
    }
}