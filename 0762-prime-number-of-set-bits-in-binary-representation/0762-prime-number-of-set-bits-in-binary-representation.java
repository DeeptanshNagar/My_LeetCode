class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        for (int i = left; i <= right; i++) {
            int n = Integer.bitCount(i);
            if (set.contains(n)) ans++;
        }
        return ans;
    }
}