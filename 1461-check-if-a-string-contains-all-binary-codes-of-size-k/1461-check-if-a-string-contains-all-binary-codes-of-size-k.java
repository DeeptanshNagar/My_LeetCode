class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (int)Math.pow(2, k);
    }
}