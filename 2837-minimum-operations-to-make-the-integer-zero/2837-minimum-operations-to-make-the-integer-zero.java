class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if (num2 == 0) return Long.bitCount((long)num1);
        long temp = num1;
        for (int i = 1; i <= 60; i++) {
            temp -= num2;
            if (temp < i) return -1;
            if (temp >= 0 && i >= Long.bitCount(temp)) return i;
        }
        return -1;
    }
}