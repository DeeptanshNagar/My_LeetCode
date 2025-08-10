class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = convert(n);
        for (int i = 1; i <= (1 << 29); i <<= 1) {
            if (s.equals(convert(i))) return true;
        }
        return false;
    }

    String convert(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        return new String(cnt);
    }
}
